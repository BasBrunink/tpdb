import { Test, TestingModule } from '@nestjs/testing';
import { AccomodationTypeController } from './accomodation-type.controller';
import { AccomodationTypeService } from './accomodation-type.service';

describe('AccomodationTypeController', () => {
  let controller: AccomodationTypeController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [AccomodationTypeController],
      providers: [AccomodationTypeService],
    }).compile();

    controller = module.get<AccomodationTypeController>(AccomodationTypeController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
