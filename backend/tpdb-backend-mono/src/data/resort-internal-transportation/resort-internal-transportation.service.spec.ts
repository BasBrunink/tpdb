import { Test, TestingModule } from '@nestjs/testing';
import { ResortInternalTransportationService } from './resort-internal-transportation.service';

describe('ResortInternalTransportationService', () => {
  let service: ResortInternalTransportationService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [ResortInternalTransportationService],
    }).compile();

    service = module.get<ResortInternalTransportationService>(ResortInternalTransportationService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
