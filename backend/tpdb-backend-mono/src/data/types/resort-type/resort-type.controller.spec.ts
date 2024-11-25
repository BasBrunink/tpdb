import { Test, TestingModule } from '@nestjs/testing';
import { ResortTypeController } from './resort-type.controller';
import { ResortTypeService } from './resort-type.service';

describe('ResortTypeController', () => {
  let controller: ResortTypeController;
  let service: ResortTypeService;

  const mockService = {};
  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [ResortTypeController],
      providers: [{ provide: ResortTypeService, useValue: mockService }],
    }).compile();

    controller = module.get<ResortTypeController>(ResortTypeController);
    service = module.get<ResortTypeService>(ResortTypeService);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
