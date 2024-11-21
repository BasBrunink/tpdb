import { Test, TestingModule } from '@nestjs/testing';
import { ParkTypeService } from './park-type.service';
import { Repository } from 'typeorm';
import { getRepositoryToken } from '@nestjs/typeorm';
import { ParkType } from './entities/park-type.entity';
import { ConflictException, NotFoundException } from '@nestjs/common';
import { CreateParkTypeDto } from './dto/create-park-type.dto';
import { UpdateParkTypeDto } from './dto/update-park-type.dto';
import { PostgresErrorCode } from '../../../database/postgresErrorCodes.enum';

describe('ParkTypeService', () => {
  let service: ParkTypeService;
  let repo: jest.Mocked<Repository<ParkType>>;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [
        ParkTypeService,
        {
          provide: getRepositoryToken(ParkType),
          useValue: {
            create: jest.fn(),
            save: jest.fn(),
            find: jest.fn(),
            findOneBy: jest.fn(),
            delete: jest.fn(),
          },
        },
      ],
    }).compile();

    service = module.get<ParkTypeService>(ParkTypeService);
    repo = module.get<jest.Mocked<Repository<ParkType>>>(
      getRepositoryToken(ParkType),
    );
  });
  describe('create', () => {
    it('should create and save a new ParkType', async () => {
      const dto: CreateParkTypeDto = {
        name: 'Theme Park',
        description: 'Themepark',
      };
      const createdEntity = {
        id: '1',
        ...dto,
        createdAt: new Date(),
        updatedAt: new Date(),
      };
      repo.create.mockReturnValue(createdEntity);
      repo.save.mockResolvedValue(createdEntity);

      const result = await service.create(dto);

      expect(repo.create).toHaveBeenCalledWith(dto);
      expect(repo.save).toHaveBeenCalledWith(createdEntity);
      expect(result).toEqual(createdEntity);
    });

    xit('should throw ConflictException if ParkType already exists', async () => {
      const dto: CreateParkTypeDto = {
        name: 'Duplicate Park',
        description: 'test',
      };

      // Mock repo.create to return a valid ParkType object
      repo.create.mockReturnValue({
        id: 'mock-id',
        name: dto.name,
        description: 'test',
        createdAt: null,
        updatedAt: null,
      });

      // Mock repo.save to reject with the unique constraint error (Postgres error code 23505)
      repo.save.mockRejectedValueOnce({
        code: PostgresErrorCode.UniqueValidation,
      });

      // Now test that the ConflictException is thrown
      await expect(service.create(dto)).rejects.toThrowError(
        new ConflictException('ParkType already exists'),
      );
    });
  });

  describe('findAll', () => {
    it('should return all ParkTypes', async () => {
      const parkTypes = [
        {
          id: '1',
          name: 'Park 1',
          description: '',
          createdAt: new Date(),
          updatedAt: new Date(),
        },
        {
          id: '2',
          name: 'Park 2',
          description: '',
          createdAt: new Date(),
          updatedAt: new Date(),
        },
      ];
      repo.find.mockResolvedValue(parkTypes);

      const result = await service.findAll();

      expect(repo.find).toHaveBeenCalled();
      expect(result).toEqual(parkTypes);
    });

    it('should throw NotFoundException if no ParkTypes exist', async () => {
      repo.find.mockResolvedValue([]);

      await expect(service.findAll()).rejects.toThrow(NotFoundException);
    });
  });

  describe('findOne', () => {
    it('should return a ParkType by ID', async () => {
      const parkType = {
        id: '1',
        name: 'Park 1',
        description: 'test',
        updatedAt: new Date(),
        createdAt: new Date(),
      };
      repo.findOneBy.mockResolvedValue(parkType);

      const result = await service.findOne('1');

      expect(repo.findOneBy).toHaveBeenCalledWith({ id: '1' });
      expect(result).toEqual(parkType);
    });

    it('should throw NotFoundException if ParkType not found', async () => {
      repo.findOneBy.mockResolvedValue(null);

      await expect(service.findOne('1')).rejects.toThrow(NotFoundException);
    });
  });

  describe('update', () => {
    it('should update a ParkType by ID', async () => {
      const dto: UpdateParkTypeDto = { name: 'Updated Park' };
      const parkType = {
        id: '1',
        name: 'Old Park',
        description: 'test',
        createdAt: new Date(),
        updatedAt: new Date(),
      };
      const updatedParkType = { ...parkType, ...dto, updatedAt: new Date() };

      repo.findOneBy.mockResolvedValue(parkType);
      repo.save.mockResolvedValue(updatedParkType);

      const result = await service.update('1', dto);

      expect(repo.findOneBy).toHaveBeenCalledWith({ id: '1' });
      expect(repo.save).toHaveBeenCalledWith({
        ...parkType,
        ...dto,
        updatedAt: expect.any(Date),
      });
      expect(result).toEqual(updatedParkType);
    });

    it('should throw NotFoundException if ParkType not found', async () => {
      repo.findOneBy.mockResolvedValue(null);

      await expect(
        service.update('1', { name: 'Updated Park' }),
      ).rejects.toThrow(NotFoundException);
    });

    it('should throw ConflictException if update causes a unique constraint violation', async () => {
      const parkType = {
        id: '1',
        name: 'Old Park',
        description: 'test',
        createdAt: new Date(),
        updatedAt: new Date(),
      };
      repo.findOneBy.mockResolvedValue(parkType);
      repo.save.mockRejectedValue({ code: '23505' }); // Mock unique constraint error

      await expect(
        service.update('1', { name: 'Duplicate Park' }),
      ).rejects.toThrow(ConflictException);
    });
  });

  describe('remove', () => {
    it('should remove a ParkType by ID', async () => {
      repo.delete.mockResolvedValue({ affected: 1, raw: {} });

      await service.remove('1');

      expect(repo.delete).toHaveBeenCalledWith('1');
    });

    it('should throw NotFoundException if ParkType not found', async () => {
      repo.delete.mockResolvedValue({ affected: 0, raw: {} });

      await expect(service.remove('1')).rejects.toThrow(NotFoundException);
    });
  });
});
