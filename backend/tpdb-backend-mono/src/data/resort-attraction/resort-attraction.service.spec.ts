import { Test, TestingModule } from '@nestjs/testing';
import { ResortAttractionService } from './resort-attraction.service';

describe('ResortAttractionService', () => {
  let service: ResortAttractionService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [ResortAttractionService],
    }).compile();

    service = module.get<ResortAttractionService>(ResortAttractionService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
