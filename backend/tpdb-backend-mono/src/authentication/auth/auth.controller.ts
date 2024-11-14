import { Body, Controller, Get, Post, Put, Req, UseGuards } from '@nestjs/common';
import { UserJwtResponse } from '../user/interfaces/user-jwt-response.interface';
import { LoginDto } from '../user/dto/login.dto';
import { SignupDto } from '../user/dto/Signup.dto';
import { User } from '../user/entities/user.entity';
import { AuthService } from './auth.service';
import { JwtAuthGuard } from './jwt.guard';

@Controller('auth')
export class AuthController {
  constructor(private readonly authService: AuthService) {}

  @Post('signup')
  async signup(@Body() signupDto: SignupDto): Promise<User> {
    return this.authService.signUp(signupDto);
  }

  @Post('login')
  async login(@Body() loginDto: LoginDto): Promise<UserJwtResponse> {
    return this.authService.login(loginDto);
  }

@UseGuards(JwtAuthGuard)
  @Get('profile')
  async profile(@Req() reg: any): Promise<User> {
    return reg.user
  }

}
