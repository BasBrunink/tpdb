import { Test, TestingModule } from '@nestjs/testing';
import { ResortTypeService } from './resort-type.service';

describe('ResortTypeService', () => {
  let service: ResortTypeService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [ResortTypeService],
    }).compile();

    service = module.get<ResortTypeService>(ResortTypeService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
