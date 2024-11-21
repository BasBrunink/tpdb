import { Test, TestingModule } from '@nestjs/testing';
import { TravelOptionService } from './travel-option.service';

describe('TravelOptionService', () => {
  let service: TravelOptionService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [TravelOptionService],
    }).compile();

    service = module.get<TravelOptionService>(TravelOptionService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
