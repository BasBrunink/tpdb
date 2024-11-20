import { Test, TestingModule } from '@nestjs/testing';
import { ResortEventsService } from './resort-events.service';

describe('ResortEventsService', () => {
  let service: ResortEventsService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [ResortEventsService],
    }).compile();

    service = module.get<ResortEventsService>(ResortEventsService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
