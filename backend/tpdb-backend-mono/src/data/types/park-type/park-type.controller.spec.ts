import { Test, TestingModule } from '@nestjs/testing';
import { ParkTypeController } from './park-type.controller';
import { ParkTypeService } from './park-type.service';
import { CreateParkTypeDto } from './dto/create-park-type.dto';
import { UpdateParkTypeDto } from './dto/update-park-type.dto';

describe('ParkTypeController', () => {
  let controller: ParkTypeController;
  let service: ParkTypeService;

  const mockParkTypeService = {
    create: jest.fn((dto: CreateParkTypeDto) => ({
      id: '1',
      ...dto,
    })),
    findAll: jest.fn(() => [
      { id: '1', type: 'Amusement Park' },
      { id: '2', type: 'Water Park' },
    ]),
    findOne: jest.fn((id: string) => ({
      id,
      name: id === '1' ? 'Amusement Park' : 'Water Park',
    })),
    update: jest.fn((id: string, dto: UpdateParkTypeDto) => ({
      id,
      ...dto,
    })),
    remove: jest.fn((id: string) => ({ id })),
  };

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [ParkTypeController],
      providers: [
        {
          provide: ParkTypeService,
          useValue: mockParkTypeService,
        },
      ],
    }).compile();

    controller = module.get<ParkTypeController>(ParkTypeController);
    service = module.get<ParkTypeService>(ParkTypeService);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });

  describe('create', () => {
    xit('should create a new park type', async () => {
      const mockReq = {
        user: { username: 'test', email: 'test@example.com' },
      };
      const dto: CreateParkTypeDto = {
        type: 'Amusement Park',
        description: 'test',
      };
      const result = await controller.create(dto, mockReq);
      expect(result).toEqual({
        id: '1',
        name: 'Amusement Park',
        description: 'test',
        createdBy: mockReq.user,
      });
      expect(service.create).toHaveBeenCalledWith(dto, mockReq);
    });
  });

  describe('findAll', () => {
    it('should return all park types', async () => {
      const result = await controller.findAll();
      expect(result).toEqual([
        { id: '1', type: 'Amusement Park' },
        { id: '2', type: 'Water Park' },
      ]);
      expect(service.findAll).toHaveBeenCalled();
    });
  });

  describe('findOne', () => {
    it('should return a single park type by id', async () => {
      const result = await controller.findOne('1');
      expect(result).toEqual({ id: '1', name: 'Amusement Park' });
      expect(service.findOne).toHaveBeenCalledWith('1');
    });
  });

  describe('update', () => {
    it('should update a park type', async () => {
      const dto: UpdateParkTypeDto = { type: 'Updated Park' };
      const result = await controller.update('1', dto);
      expect(result).toEqual({ id: '1', type: 'Updated Park' });
      expect(service.update).toHaveBeenCalledWith('1', dto);
    });
  });

  describe('remove', () => {
    it('should remove a park type', async () => {
      const result = await controller.remove('1');
      expect(result).toEqual({ id: '1' });
      expect(service.remove).toHaveBeenCalledWith('1');
    });
  });
});
