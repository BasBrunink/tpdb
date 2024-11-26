import { Test, TestingModule } from '@nestjs/testing';
import { UserController } from './user.controller';
import { UserService } from './user.service';
import { CreateUserDto } from './dto/create-user.dto';
import { User } from './entities/user.entity';

describe('UserController', () => {
  let userController: UserController;
  let userService: jest.Mocked<UserService>;

  const mockUserService = {
    create: jest.fn(),
  };

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [UserController],
      providers: [{ provide: UserService, useValue: mockUserService }],
    }).compile();

    userController = module.get<UserController>(UserController);
    userService = module.get<UserService>(
      UserService,
    ) as jest.Mocked<UserService>;
  });

  it('should be defined', () => {
    expect(userController).toBeDefined();
  });
  describe('create', () => {
    it('should call userService.create with the correct parameters and return the created user', async () => {
      // Arrange
      const createUserDto: CreateUserDto = {
        username: 'testuser',
        email: 'test@example.com',
        password: 'password123',
      };
      const mockUser: User = new User();

      mockUser.id = '1';
      mockUser.username = 'testuser';
      mockUser.email = 'test@example.com';
      mockUser.password = 'password123';

      mockUserService.create.mockResolvedValue(mockUser);

      // Act
      const result = await userController.create(createUserDto);

      // Assert
      expect(userService.create).toHaveBeenCalledWith(createUserDto);
      expect(result).toEqual(mockUser);
    });
  });
});
