import { Test, TestingModule } from '@nestjs/testing';
import { AccommodationController } from './accommodation.controller';
import { AccomodationService } from './accomodation.service';

describe('AccomodationController', () => {
  let controller: AccommodationController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [AccommodationController],
      providers: [AccomodationService],
    }).compile();

    controller = module.get<AccommodationController>(AccommodationController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
