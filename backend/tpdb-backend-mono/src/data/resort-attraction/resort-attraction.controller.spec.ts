import { Test, TestingModule } from '@nestjs/testing';
import { ResortAttractionController } from './resort-attraction.controller';
import { ResortAttractionService } from './resort-attraction.service';

describe('ResortAttractionController', () => {
  let controller: ResortAttractionController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [ResortAttractionController],
      providers: [ResortAttractionService],
    }).compile();

    controller = module.get<ResortAttractionController>(ResortAttractionController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
