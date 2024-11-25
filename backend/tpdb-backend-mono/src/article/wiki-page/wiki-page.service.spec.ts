import { Test, TestingModule } from '@nestjs/testing';
import { WikiPageService } from './wiki-page.service';

describe('WikiPageService', () => {
  let service: WikiPageService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [WikiPageService],
    }).compile();

    service = module.get<WikiPageService>(WikiPageService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
