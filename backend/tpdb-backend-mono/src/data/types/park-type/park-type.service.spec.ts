import { Test, TestingModule } from '@nestjs/testing';
import { ParkTypeService } from './park-type.service';

describe('ParkTypeService', () => {
  let service: ParkTypeService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [ParkTypeService],
    }).compile();

    service = module.get<ParkTypeService>(ParkTypeService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
