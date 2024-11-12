import { Test, TestingModule } from '@nestjs/testing';
import { ParkTypeController } from './park-type.controller';
import { ParkTypeService } from './park-type.service';

describe('ParkTypeController', () => {
  let controller: ParkTypeController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [ParkTypeController],
      providers: [ParkTypeService],
    }).compile();

    controller = module.get<ParkTypeController>(ParkTypeController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
