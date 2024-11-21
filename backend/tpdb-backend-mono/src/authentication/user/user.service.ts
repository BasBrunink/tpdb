import { ConflictException, HttpException, HttpStatus, Injectable } from '@nestjs/common';
import * as bcrypt from 'bcrypt';

import { InjectRepository } from '@nestjs/typeorm';
import { User } from './entities/user.entity';
import { Repository } from 'typeorm';
import { SignupDto } from './dto/Signup.dto';
import { LoginDto } from './dto/login.dto';
import { LoginResponseDto } from './dto/loginResponse.dto';
import { ConfigService } from '@nestjs/config';
import { PostgresErrorCode } from '../../database/postgresErrorCodes.enum';

@Injectable()
export class UserService {
  constructor(
    @InjectRepository(User)
    private userRepository: Repository<User>,
    private readonly configService: ConfigService,
  ) {
  }

  findById(id: string): Promise<User> {
    return this.userRepository.findOne({ where: { id } });
  }

  async create(signupDto: SignupDto): Promise<User> {
    const { email, password, username } = signupDto;
    const user = new User();
    user.password = await this._hashPassword(password, this.configService.get('SALT'));
    user.email = email;
    user.username = username;

    try {
      await this.userRepository.save(user);
      return user;
    } catch (error) {
      if (error.code == PostgresErrorCode.UniqueValidation) {
        throw new ConflictException('This email is not unique');
      } else {
        throw new HttpException(
          `Error creating ParkType: ${error.message}`,
          HttpStatus.INTERNAL_SERVER_ERROR,
        );
      }
    }
  }

  async signIn(loginDto: LoginDto): Promise<LoginResponseDto> {
    const { email, password } = loginDto;
    const user = await this.userRepository.findOne({ where: { email } });
    console.log(user);
    this._hashPassword(password, this.configService.get('SALT')).then((x) => {
      console.log(x);
    });

    if (user && (await this._validatePassword(password, user.password))) {
      const userResponse = new LoginResponseDto();
      userResponse.username = user.username;
      userResponse.email = user.email;
      return userResponse;
    } else {
      return null;
    }
  }

  async findByUserName(username: string) {
    return await this.userRepository.findOne({ where: { username } });
  }

  async _validatePassword(password: string, hashed: string): Promise<boolean> {
    if (password) {
      const hash = await this._hashPassword(
        password,
        this.configService.get('SALT'),
      );
      const x = hash === hashed;
      return x;
    } else {
      return Promise.resolve(false);
    }
  }

  private async _hashPassword(password: string, salt: string): Promise<string> {
    return bcrypt.hash(password, salt);
  }
}
