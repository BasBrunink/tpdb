import { Test, TestingModule } from '@nestjs/testing';
import { AttractionTypeController } from './attraction-type.controller';
import { AttractionTypeService } from './attraction-type.service';

describe('AttractionTypeController', () => {
  let controller: AttractionTypeController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [AttractionTypeController],
      providers: [AttractionTypeService],
    }).compile();

    controller = module.get<AttractionTypeController>(AttractionTypeController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
