import { Test, TestingModule } from '@nestjs/testing';
import { AuthController } from './auth.controller';
import { AuthService } from './auth.service';
import { SignupDto } from '../user/dto/Signup.dto';
import { LoginDto } from '../user/dto/login.dto';
import { UnauthorizedException } from '@nestjs/common';

describe('AuthController', () => {
  let authController: AuthController;
  let authService: AuthService;
  const mockAuthService = {
    signUp: jest.fn(),
    login: jest.fn(),
    findUserByUsername: jest.fn(),
    findUserById: jest.fn(),
  };
  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [AuthController],
      providers: [{ provide: AuthService, useValue: mockAuthService }],
    }).compile();

    authController = module.get<AuthController>(AuthController);
    authService = module.get<AuthService>(AuthService);
  });

  it('should be defined', () => {
    expect(authController).toBeDefined();
    expect(authService).toBeDefined();
  });
  describe('signUp', () => {
    it('should create a new user', async () => {
      const signupDto: SignupDto = {
        username: 'testuser',
        password: 'password123',
        email: 'test@example.com',
      };

      const mockUser = { id: '1', ...signupDto };
      mockAuthService.signUp.mockResolvedValue(mockUser);

      const result = await authController.signup(signupDto);
      expect(result).toEqual(mockUser);
      expect(mockAuthService.signUp).toHaveBeenCalledWith(signupDto);
    });
  });

  describe('login', () => {
    it('should return a JWT token and user data for valid credentials', async () => {
      const loginDto: LoginDto = {
        email: 'testuser',
        password: 'password123',
      };

      const mockResponse = {
        user: { id: '1', username: 'testuser' },
        accessToken: 'mockToken123',
      };
      mockAuthService.login.mockResolvedValue(mockResponse);

      const result = await authController.login(loginDto);
      expect(result).toEqual(mockResponse);
      expect(mockAuthService.login).toHaveBeenCalledWith(loginDto);
    });

    it('should throw UnauthorizedException for invalid credentials', async () => {
      const loginDto: LoginDto = {
        email: 'testuser',
        password: 'wrongpassword',
      };

      mockAuthService.login.mockRejectedValue(
        new UnauthorizedException('Invalid Credentials!'),
      );

      await expect(authController.login(loginDto)).rejects.toThrow(
        UnauthorizedException,
      );
      expect(mockAuthService.login).toHaveBeenCalledWith(loginDto);
    });
  });
});
