import { Injectable, UnauthorizedException } from '@nestjs/common';
import { UserService } from '../user/user.service';
import { JwtService } from '@nestjs/jwt';
import { SignupDto } from '../user/dto/Signup.dto';
import { User } from '../user/entities/user.entity';
import { UserJwtResponse } from '../user/interfaces/user-jwt-response.interface';
import { LoginDto } from '../user/dto/login.dto';
import { JwtToken } from './jwtToken.interface';



@Injectable()
export class AuthService {

  constructor(
    private readonly userService: UserService,
    private readonly jwtService: JwtService,
  ) {}

  async validateUserByUsername(username: string) {
    return await this.userService.findByUserName(username);
  }
  async validateUserById(userId: string) {
    const x = await this.userService.findById(userId);
    console.dir(x);
    return x;
  }

  async signUp(signupDto: SignupDto): Promise<User> {
    return this.userService.create(signupDto);
  }

  async login(loginDto: LoginDto): Promise<UserJwtResponse> {
    const userResult = await this.userService.signIn(loginDto);

    if (!userResult) {
      throw new UnauthorizedException('Invalid Credentials!');
    }

    const user = await this.userService.findByUserName(userResult.username);
    const payload: JwtToken = {
      username: user.username,
      userId: user.id,
      role: 'admin',
    };
    const accessToken = await this.jwtService.sign(payload);

    const signInResponse: UserJwtResponse = { user: userResult, accessToken };

    return signInResponse;
  }

}
