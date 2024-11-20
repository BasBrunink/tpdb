import { Injectable } from '@nestjs/common';
import * as bcrypt from 'bcrypt';

import { InjectRepository } from '@nestjs/typeorm';
import { User } from './entities/user.entity';
import { Repository } from 'typeorm';
import { SignupDto } from './dto/Signup.dto';
import { LoginDto } from './dto/login.dto';
import { LoginResponseDto } from './dto/loginResponse.dto';


@Injectable()
export class UserService {
  constructor(
    @InjectRepository(User)
    private userRepository: Repository<User>,
  ) {}

  findById(id: string): Promise<User> {
    return this.userRepository.findOne({ where: { id } });
  }

  private async hashPassword(password: string, salt: string): Promise<string> {
    return bcrypt.hash(password, salt);
  }

  async create(signupDto: SignupDto): Promise<User> {
    const { email, password, username } = signupDto;
    const user = new User();

    user.salt = await bcrypt.genSalt();
    user.password = await this.hashPassword(password, user.salt);
    user.email = email;
    user.username = username;

    try {
      await this.userRepository.save(user);
      return user;
    } catch (error) {
      throw error;
    }
  }

  async signIn(loginDto: LoginDto): Promise<LoginResponseDto> {
    const { email, password } = loginDto;
    const user = await this.userRepository.findOne({ where: { email } });
    if (user && (await user.validatePassword(password))) {
      const userResponse = new LoginResponseDto();
      userResponse.username = user.username;
      userResponse.email = user.email;
      return userResponse;
    } else {
      return null;
    }
  }

  async findByUserName(username: string) {
    return await this.userRepository.findOne({ where: { username }});
  }
}
