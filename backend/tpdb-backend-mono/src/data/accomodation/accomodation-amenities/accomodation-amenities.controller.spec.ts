import { Test, TestingModule } from '@nestjs/testing';
import { AccomodationAmenitiesController } from './accomodation-amenities.controller';
import { AccomodationAmenitiesService } from './accomodation-amenities.service';

describe('AccomodationAmenitiesController', () => {
  let controller: AccomodationAmenitiesController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [AccomodationAmenitiesController],
      providers: [AccomodationAmenitiesService],
    }).compile();

    controller = module.get<AccomodationAmenitiesController>(
      AccomodationAmenitiesController,
    );
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
