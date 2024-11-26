import { Test, TestingModule } from '@nestjs/testing';
import { EntryFeeController } from './entry-fee.controller';
import { EntryFeeService } from './entry-fee.service';

describe('EntryFeeController', () => {
  let controller: EntryFeeController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [EntryFeeController],
      providers: [EntryFeeService],
    }).compile();

    controller = module.get<EntryFeeController>(EntryFeeController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
