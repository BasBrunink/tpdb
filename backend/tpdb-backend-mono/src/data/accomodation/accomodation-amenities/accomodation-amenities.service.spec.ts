import { Test, TestingModule } from '@nestjs/testing';
import { AccomodationAmenitiesService } from './accomodation-amenities.service';

describe('AccomodationAmenitiesService', () => {
  let service: AccomodationAmenitiesService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [AccomodationAmenitiesService],
    }).compile();

    service = module.get<AccomodationAmenitiesService>(AccomodationAmenitiesService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
