import { Test, TestingModule } from '@nestjs/testing';
import { AccommodationTypeService } from './accommodation-type.service';

describe('AccomodationTypeService', () => {
  let service: AccommodationTypeService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [AccommodationTypeService],
    }).compile();

    service = module.get<AccommodationTypeService>(AccommodationTypeService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
