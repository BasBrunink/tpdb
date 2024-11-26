import { Test, TestingModule } from '@nestjs/testing';
import { AccommodationAmenitiesController } from './accommodation-amenities.controller';
import { AccommodationAmenitiesService } from './accommodation-amenities.service';

describe('AccomodationAmenitiesController', () => {
  let controller: AccommodationAmenitiesController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [AccommodationAmenitiesController],
      providers: [AccommodationAmenitiesService],
    }).compile();

    controller = module.get<AccommodationAmenitiesController>(
      AccommodationAmenitiesController,
    );
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
