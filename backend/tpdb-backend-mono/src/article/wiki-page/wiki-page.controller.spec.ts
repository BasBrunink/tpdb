import { Test, TestingModule } from '@nestjs/testing';
import { WikiPageController } from './wiki-page.controller';
import { WikiPageService } from './wiki-page.service';

describe('WikiPageController', () => {
  let controller: WikiPageController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [WikiPageController],
      providers: [WikiPageService],
    }).compile();

    controller = module.get<WikiPageController>(WikiPageController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
