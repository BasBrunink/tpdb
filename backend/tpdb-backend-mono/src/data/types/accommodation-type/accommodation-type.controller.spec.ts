import { Test, TestingModule } from '@nestjs/testing';
import { AccommodationTypeController } from './accommodation-type.controller';
import { AccommodationTypeService } from './accommodation-type.service';

describe('AccomodationTypeController', () => {
  let controller: AccommodationTypeController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [AccommodationTypeController],
      providers: [AccommodationTypeService],
    }).compile();

    controller = module.get<AccommodationTypeController>(
      AccommodationTypeController,
    );
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
