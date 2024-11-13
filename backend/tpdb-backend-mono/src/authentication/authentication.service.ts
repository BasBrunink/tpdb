import { HttpException, HttpStatus, Injectable } from '@nestjs/common';
import { UserService } from './user/user.service';
import * as bcrypt from 'bcrypt';
import { RegisterDto } from './dto/register.dto';

@Injectable()
export class AuthenticationService {

  constructor( private readonly userService: UserService) {}

  public async register(registerData: RegisterDto) {
    const hashPassword = await bcrypt.hash(registerData.password, 10);
    try {
      const createdUser = await this.userService.create({
        ...registerData,
        password: hashPassword
      });
      createdUser.password = undefined;
      return createdUser;
    } catch (error) {
      if(error?.code === PostgresErrorCode.UniqueValidation) {
        throw new HttpException('User with email already exists', HttpStatus.BAD_REQUEST);
      }
      throw new HttpException('Something went wrong', HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  public async getAuthenticatedUser(email: string, plainTextPassword: string) {
    try {
      const user = await this.userService.findOneByEmail(email);
      await this._verifyPassword(plainTextPassword, user.password);
      user.password = undefined;
      return user;
    } catch (error) {
      throw new HttpException('Invalid credentials', HttpStatus.BAD_REQUEST);
    }
  }
  private async _verifyPassword(plainTextPassword: string, hashedPassword: string) {
    const isPasswordMatching = await bcrypt.compare(plainTextPassword, hashedPassword);
    if(!isPasswordMatching) {
      throw new HttpException('Invalid credentials', HttpStatus.BAD_REQUEST);
    }
  }
}
