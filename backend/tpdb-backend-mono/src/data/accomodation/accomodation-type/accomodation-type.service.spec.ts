import { Test, TestingModule } from '@nestjs/testing';
import { AccomodationTypeService } from './accomodation-type.service';

describe('AccomodationTypeService', () => {
  let service: AccomodationTypeService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [AccomodationTypeService],
    }).compile();

    service = module.get<AccomodationTypeService>(AccomodationTypeService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
