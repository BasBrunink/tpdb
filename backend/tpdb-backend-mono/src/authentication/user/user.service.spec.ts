import { Test, TestingModule } from '@nestjs/testing';
import { UserService } from './user.service';
import { Repository } from 'typeorm';
import { User } from './entities/user.entity';
import { getRepositoryToken } from '@nestjs/typeorm';
import { SignupDto } from './dto/Signup.dto';

import * as bcrypt from 'bcrypt';
import { LoginDto } from './dto/login.dto';
import { ConfigService } from '@nestjs/config';

describe('UserService', () => {
  let userService: UserService;
  let userRepo: Repository<User>;
  let configService: ConfigService;

  const mockUserRepository = {
    findOne: jest.fn(),
    save: jest.fn(),
  };

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [
        UserService,
        ConfigService,
        { provide: getRepositoryToken(User), useValue: mockUserRepository },
      ],
    }).compile();

    userService = module.get<UserService>(UserService);
    userRepo = module.get<Repository<User>>(getRepositoryToken(User));
  });

  it('should be defined', () => {
    expect(userService).toBeDefined();
  });
  describe('findById', () => {
    it('should return a user if found', async () => {
      const mockUser = new User();
      mockUser.id = '1';
      mockUser.username = 'testuser';

      mockUserRepository.findOne.mockResolvedValue(mockUser);

      const result = await userService.findById('1');

      expect(userRepo.findOne).toHaveBeenCalledWith({ where: { id: '1' } });
      expect(result).toEqual(mockUser);
    });
  });

  describe('create', () => {
    it('should hash the password and save the user', async () => {
      const signupDto: SignupDto = {
        email: 'test@example.com',
        password: 'password123',
        username: 'testuser',
      };

      const mockUser = new User();
      mockUser.email = signupDto.email;
      mockUser.username = signupDto.username;

      jest
        .spyOn(bcrypt, 'genSalt')
        .mockImplementation(() => Promise.resolve('randomSalt'));
      jest
        .spyOn(bcrypt, 'hash')
        .mockImplementation(() => Promise.resolve('hashedPassword'));
      mockUserRepository.save.mockResolvedValue(mockUser);

      const result = await userService.create(signupDto);

      expect(bcrypt.genSalt).toHaveBeenCalled();
      expect(bcrypt.hash).toHaveBeenCalledWith(
        signupDto.password,
        'randomSalt',
      );
      expect(userRepo.save).toHaveBeenCalledWith(
        expect.objectContaining({
          email: signupDto.email,
          username: signupDto.username,
          password: 'hashedPassword',
          salt: 'randomSalt',
        }),
      );
      mockUser.password = 'hashedPassword';
      mockUser.salt = 'randomSalt';
      expect(result).toEqual(mockUser);
    });
  });

  describe('signIn', () => {
    it('should return login response if password is valid', async () => {
      const loginDto: LoginDto = {
        email: 'test@example.com',
        password: 'password123',
      };

      const mockUser = new User();
      mockUser.username = 'testuser';
      mockUser.email = loginDto.email;

      mockUserRepository.findOne.mockResolvedValue(mockUser);

      const result = await userService.signIn(loginDto);

      expect(userRepo.findOne).toHaveBeenCalledWith({
        where: { email: loginDto.email },
      });

      expect(result).toEqual({
        username: mockUser.username,
        email: mockUser.email,
      });
    });

    it('should return null if password is invalid', async () => {
      const loginDto: LoginDto = {
        email: 'test@example.com',
        password: 'wrongPassword',
      };

      const mockUser = new User();

      mockUserRepository.findOne.mockResolvedValue(mockUser);

      const result = await userService.signIn(loginDto);

      expect(result).toBeNull();
    });

    it('should return null if user is not found', async () => {
      const loginDto: LoginDto = {
        email: 'notfound@example.com',
        password: 'password123',
      };

      mockUserRepository.findOne.mockResolvedValue(null);

      const result = await userService.signIn(loginDto);

      expect(userRepo.findOne).toHaveBeenCalledWith({
        where: { email: loginDto.email },
      });
      expect(result).toBeNull();
    });
  });

  describe('findByUserName', () => {
    it('should return a user if found by username', async () => {
      const mockUser = new User();
      mockUser.username = 'testuser';

      mockUserRepository.findOne.mockResolvedValue(mockUser);

      const result = await userService.findByUserName('testuser');

      expect(userRepo.findOne).toHaveBeenCalledWith({
        where: { username: 'testuser' },
      });
      expect(result).toEqual(mockUser);
    });
  });
});
