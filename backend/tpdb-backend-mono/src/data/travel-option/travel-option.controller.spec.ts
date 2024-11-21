import { Test, TestingModule } from '@nestjs/testing';
import { TravelOptionController } from './travel-option.controller';
import { TravelOptionService } from './travel-option.service';

describe('TravelOptionController', () => {
  let controller: TravelOptionController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [TravelOptionController],
      providers: [TravelOptionService],
    }).compile();

    controller = module.get<TravelOptionController>(TravelOptionController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
