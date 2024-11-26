import { Test, TestingModule } from '@nestjs/testing';
import { EntryFeeService } from './entry-fee.service';

describe('EntryFeeService', () => {
  let service: EntryFeeService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [EntryFeeService],
    }).compile();

    service = module.get<EntryFeeService>(EntryFeeService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
