import { Test, TestingModule } from '@nestjs/testing';
import { ParkTypeService } from './park-type.service';
import { Repository } from 'typeorm';
import { getRepositoryToken } from '@nestjs/typeorm';
import { ParkType } from './entities/park-type.entity';
import { User } from '../../../authentication/user/entities/user.entity';
import { ConflictException, NotFoundException } from '@nestjs/common';
import { PostgresErrorCode } from '../../../database/postgresErrorCodes.enum';

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

describe('ParkTypeService', () => {
  let service: ParkTypeService;
  let repo: Repository<ParkType>;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [
        ParkTypeService,
        { provide: getRepositoryToken(ParkType), useValue: mockRepo },
      ],
    }).compile();

    service = module.get<ParkTypeService>(ParkTypeService);
    repo = module.get<Repository<ParkType>>(getRepositoryToken(ParkType));
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });

  describe('create', () => {
    it('should create a new ParkType', async () => {
      const createDto = { type: 'Theme Park', description: 'A fun park' };
      const savedParkType = { ...createDto, id: '123', createdAt: new Date() };
      mockRepo.create.mockReturnValue(savedParkType);
      mockRepo.save.mockResolvedValue(savedParkType);

      const result = await service.create(createDto, mockUser);
      expect(mockRepo.create).toHaveBeenCalledWith({
        ...createDto,
        createdAt: expect.any(Date),
        updatedAt: expect.any(Date),
        createdBy: mockUser,
        updatedBy: mockUser,
      });
      expect(mockRepo.save).toHaveBeenCalledWith(savedParkType);
      expect(result).toEqual(savedParkType);
    });

    xit('should throw a ConflictException if ParkType already exists', async () => {
      mockRepo.save.mockRejectedValue({
        code: PostgresErrorCode.UniqueValidation,
      }); // Simulate unique constraint violation
      const createDto = { type: 'Theme Park', description: 'A fun park' };

      await expect(service.create(createDto, mockUser)).rejects.toThrow(
        ConflictException,
      );
    });
  });

  describe('findAll', () => {
    it('should return all ParkTypes', async () => {
      const parkTypes = [
        { id: '123', name: 'Theme Park', description: 'A fun park' },
      ];
      mockRepo.find.mockResolvedValue(parkTypes);

      const result = await service.findAll();
      expect(mockRepo.find).toHaveBeenCalledTimes(1);
      expect(result).toEqual(parkTypes);
    });

    it('should throw NotFoundException if no ParkTypes are found', async () => {
      mockRepo.find.mockResolvedValue([]);
      await expect(service.findAll()).rejects.toThrow(NotFoundException);
    });
  });

  describe('findOne', () => {
    it('should return a ParkType by ID', async () => {
      const parkType = { id: '123', name: 'Theme Park' };
      mockRepo.findOneBy.mockResolvedValue(parkType);

      const result = await service.findOne('123');
      expect(mockRepo.findOneBy).toHaveBeenCalledWith({ id: '123' });
      expect(result).toEqual(parkType);
    });

    it('should throw NotFoundException if ParkType is not found', async () => {
      mockRepo.findOneBy.mockResolvedValue(null);

      await expect(service.findOne('123')).rejects.toThrow(NotFoundException);
    });
  });

  describe('update', () => {
    it('should update a ParkType', async () => {
      const updateDto = { type: 'Updated Park' };
      const existingParkType = {
        id: '123',
        name: 'Theme Park',
        updatedAt: new Date(),
      };
      const updatedParkType = {
        ...existingParkType,
        ...updateDto,
        updatedAt: new Date(),
      };

      mockRepo.findOneBy.mockResolvedValue(existingParkType);
      mockRepo.save.mockResolvedValue(updatedParkType);

      const result = await service.update('123', updateDto);
      expect(mockRepo.findOneBy).toHaveBeenCalledWith({ id: '123' });
      expect(mockRepo.save).toHaveBeenCalledWith(
        expect.objectContaining(updatedParkType),
      );
      expect(result).toEqual(updatedParkType);
    });

    it('should throw NotFoundException if ParkType is not found', async () => {
      mockRepo.findOneBy.mockResolvedValue(null);
      const updateDto = { type: 'Updated Park' };

      await expect(service.update('123', updateDto)).rejects.toThrow(
        NotFoundException,
      );
    });
  });

  describe('remove', () => {
    it('should remove a ParkType by ID', async () => {
      mockRepo.delete.mockResolvedValue({ affected: 1 });

      await service.remove('123');
      expect(mockRepo.delete).toHaveBeenCalledWith('123');
    });

    it('should throw NotFoundException if ParkType is not found', async () => {
      mockRepo.delete.mockResolvedValue({ affected: 0 });

      await expect(service.remove('123')).rejects.toThrow(NotFoundException);
    });
  });
});
