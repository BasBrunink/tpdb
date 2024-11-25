import { Test, TestingModule } from '@nestjs/testing';
import { ResortTypeService } from './resort-type.service';
import { User } from '../../../authentication/user/entities/user.entity';
import { Repository } from 'typeorm';
import { ResortType } from './entities/resort-type.entity';
import { getRepositoryToken } from '@nestjs/typeorm';


const mockRepo = {
  create: jest.fn(),
  save: jest.fn(),
  find: jest.fn(),
  findOneBy: jest.fn(),
  delete: jest.fn(),
};

const mockUser: User = {
  id: 'user123',
  username: 'testuser',
  email: 'test@example.com',
  password: 'hashedpassword',
};

describe('ResortTypeService', () => {
  let service: ResortTypeService;
  let repo: Repository<ResortType>;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [ResortTypeService, {provide: getRepositoryToken(ResortType), useValue: mockRepo}],
    }).compile();

    service = module.get<ResortTypeService>(ResortTypeService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
