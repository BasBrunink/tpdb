import { Test, TestingModule } from '@nestjs/testing';
import { JwtStrategy } from './jwt.strategy';
import { AuthService } from './auth.service';
import { ConfigService } from '@nestjs/config';
import { JwtToken } from './jwtToken.interface';
import { User } from '../user/entities/user.entity';

describe('JwtStrategy', () => {
  let strategy: JwtStrategy;
  let authService: jest.Mocked<AuthService>;

  beforeEach(async () => {
    const mockAuthService = {
      validateUserById: jest.fn(),
    };

    const mockConfigService = {
      get: jest.fn().mockImplementation((key: string) => {
        if (key === 'JWT_SECRET') return 'test-secret';
        return null;
      }),
    };

    const module: TestingModule = await Test.createTestingModule({
      providers: [
        JwtStrategy,
        { provide: AuthService, useValue: mockAuthService },
        { provide: ConfigService, useValue: mockConfigService },
      ],
    }).compile();

    strategy = module.get<JwtStrategy>(JwtStrategy);
    authService = module.get(AuthService);
  });

  it('should be defined', () => {
    expect(strategy).toBeDefined();
  });

  describe('validate', () => {
    it('should return a user object for valid payloads', async () => {
      const payload: JwtToken = { userId: '1', username: 'test', role: 'test' };
      const mockUser: User = new User();

      mockUser.id = '1';
      mockUser.username = 'testuser';
      mockUser.email = 'test@example.com';
      mockUser.password = 'password123';
      mockUser.salt = '';

      authService.validateUserById.mockResolvedValue(mockUser);

      const result = await strategy.validate(payload);
      expect(authService.validateUserById).toHaveBeenCalledWith('1');
      expect(result).toEqual(mockUser);
    });

    xit('should throw an error if user is not found', async () => {
      const payload: JwtToken = {
        userId: '1',
        username: 'test',
        role: 'admin',
      };
      authService.validateUserById.mockResolvedValue(null);

      await expect(strategy.validate(payload)).rejects.toThrow('Unauthorized');
      expect(authService.validateUserById).toHaveBeenCalledWith(1);
    });

    xit('should handle missing payload gracefully', async () => {
      await expect(strategy.validate(null)).rejects.toThrow('Unauthorized');
    });
  });
});
