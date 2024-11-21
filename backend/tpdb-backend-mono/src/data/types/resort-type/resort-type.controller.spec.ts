import { Test, TestingModule } from '@nestjs/testing';
import { ResortTypeController } from './resort-type.controller';
import { ResortTypeService } from './resort-type.service';

describe('ResortTypeController', () => {
  let controller: ResortTypeController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [ResortTypeController],
      providers: [ResortTypeService],
    }).compile();

    controller = module.get<ResortTypeController>(ResortTypeController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
