import { Test, TestingModule } from '@nestjs/testing';
import { ResortEventsController } from './resort-events.controller';
import { ResortEventsService } from './resort-events.service';

describe('ResortEventsController', () => {
  let controller: ResortEventsController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [ResortEventsController],
      providers: [ResortEventsService],
    }).compile();

    controller = module.get<ResortEventsController>(ResortEventsController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
