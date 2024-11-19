import { Test, TestingModule } from '@nestjs/testing';
import { AuthService } from './auth.service';
import { UserService } from '../user/user.service';
import { JwtService } from '@nestjs/jwt';
import { UnauthorizedException } from '@nestjs/common';
import { UserJwtResponse } from '../user/interfaces/user-jwt-response.interface';
import { LoginDto } from '../user/dto/login.dto';
import { User } from '../user/entities/user.entity';
import { SignupDto } from '../user/dto/Signup.dto';

describe('AuthService', () => {
  let authService: AuthService;
  let userService: UserService;
  let jwtService: JwtService;

  const mockUserService = {
    signIn: jest.fn(),
    findByUserName: jest.fn(),
    findById: jest.fn(),
    create: jest.fn(),
  };

  const mockJwtService = {
    sign: jest.fn(),
  };

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [
        AuthService,
        { provide: UserService, useValue: mockUserService },
        { provide: JwtService, useValue: mockJwtService },
      ],
    }).compile();

    authService = module.get<AuthService>(AuthService);
    userService = module.get<UserService>(UserService);
    jwtService = module.get<JwtService>(JwtService);
  });

  it('should be defined', () => {
    expect(authService).toBeDefined();
  });

  describe('login', () => {
    it('should return a user with a valid JWT token', async () => {
      const loginDto: LoginDto = {
        email: 'testuser@example.com',
        password: 'password',
      };

      const mockUser = { username: 'testuser', id: '1', role: 'admin' };
      const mockJwtToken = 'valid-jwt-token';

      mockUserService.signIn.mockResolvedValue(mockUser); // Mocking signIn method
      mockUserService.findByUserName.mockResolvedValue(mockUser); // Mocking findByUserName method
      mockJwtService.sign.mockReturnValue(mockJwtToken); // Mocking JWT signing

      const result: UserJwtResponse = await authService.login(loginDto);

      expect(result).toHaveProperty('user');
      expect(result.user.username).toBe('testuser');
      expect(result).toHaveProperty('accessToken');
      expect(result.accessToken).toBe(mockJwtToken);
      expect(mockUserService.signIn).toHaveBeenCalledWith(loginDto); // Ensure method is called
      expect(mockJwtService.sign).toHaveBeenCalled(); // Ensure JWT signing method is called
    });

    it('should throw UnauthorizedException if invalid credentials are provided', async () => {
      const loginDto: LoginDto = {
        email: 'invaliduser@example.com',
        password: 'wrongpassword',
      };

      mockUserService.signIn.mockResolvedValue(null); // Simulate invalid credentials

      try {
        await authService.login(loginDto);
      } catch (e) {
        expect(e).toBeInstanceOf(UnauthorizedException);
        expect(e.message).toBe('Invalid Credentials!');
      }
    });
  });
  describe('signup', () => {
    it('should return a user when the create is succesfull', async () => {
      const signup: SignupDto = {
        email: 'test@example.com',
        password: 'test',
        username: 'test',
      };
      const mockUser = new User();
      mockUser.id = '1';
      mockUser.username = 'test';
      mockUser.password = 'test';
      mockUser.email = 'test@example.com';
      mockUser.salt = '2323';
      mockUserService.create.mockResolvedValue(mockUser);
      const result = await authService.signUp(signup);
      expect(result).toHaveProperty('username');
      expect(result.username).toBe('test');
    });
  });
  describe('validateUserByUserName', () => {
    it('should return return an user when Id is given ', async () => {
      const mockUser = new User();
      mockUser.id = '1';
      mockUser.username = 'test';
      mockUser.password = 'test';
      mockUser.email = 'test@example.com';
      mockUser.salt = '2323';
      mockUserService.findById.mockResolvedValue(mockUser);
      const result = await authService.validateUserById('1');
      expect(result).toHaveProperty('username');
      expect(result.username).toBe('test');
    });
  });
});
