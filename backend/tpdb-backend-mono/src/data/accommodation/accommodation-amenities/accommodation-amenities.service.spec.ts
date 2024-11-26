import { Test, TestingModule } from '@nestjs/testing';
import { AccommodationAmenitiesService } from './accommodation-amenities.service';

describe('AccomodationAmenitiesService', () => {
  let service: AccommodationAmenitiesService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [AccommodationAmenitiesService],
    }).compile();

    service = module.get<AccommodationAmenitiesService>(
      AccommodationAmenitiesService,
    );
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
