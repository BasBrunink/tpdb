import { Test, TestingModule } from '@nestjs/testing';
import { AttractionTypeService } from './attraction-type.service';

describe('AttractionTypeService', () => {
  let service: AttractionTypeService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [AttractionTypeService],
    }).compile();

    service = module.get<AttractionTypeService>(AttractionTypeService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
