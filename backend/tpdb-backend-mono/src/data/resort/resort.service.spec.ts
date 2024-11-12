import { Test, TestingModule } from '@nestjs/testing';
import { ResortService } from './resort.service';

describe('ResortService', () => {
  let service: ResortService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [ResortService],
    }).compile();

    service = module.get<ResortService>(ResortService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
