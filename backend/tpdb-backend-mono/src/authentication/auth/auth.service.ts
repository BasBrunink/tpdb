import { Injectable, UnauthorizedException } from '@nestjs/common';
import { UserService } from '../user/user.service';
import { JwtService } from '@nestjs/jwt';
import { SignupDto } from '../user/dto/Signup.dto';
import { User } from '../user/entities/user.entity';
import { UserJwtResponse } from '../user/interfaces/user-jwt-response.interface';
import { LoginDto } from '../user/dto/login.dto';
import { JwtToken } from './jwtToken.interface';
import { UserResponse } from '../user/dto/user-response.dto';



@Injectable()
export class AuthService {
  constructor(
    private readonly userService: UserService,
    private readonly jwtService: JwtService,
  ) {}

  async validateUserById(userId: string): Promise<User> {
    return this.userService.findById(userId);
  }

  async signUp(signupDto: SignupDto): Promise<User> {
    return this.userService.create(signupDto);
  }

  async login(loginDto: LoginDto): Promise<UserJwtResponse> {
    const userResult = await this.userService.signIn(loginDto);
    console.log(userResult);

    if (!userResult) {
      throw new UnauthorizedException('Invalid Credentials!');
    }

    const user = await this.userService.findByUserName(userResult.username);
    const payload: JwtToken = {
      username: user.username,
      userId: user.id,
      role: 'admin',
    };
    const accessToken = this.jwtService.sign(payload);

    return { user: userResult, accessToken } as UserJwtResponse;
  }
}
