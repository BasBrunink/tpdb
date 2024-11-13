import { Test, TestingModule } from '@nestjs/testing';
import { ResortService } from './resort.service';
import { getRepositoryToken, TypeOrmModule } from '@nestjs/typeorm';
import { Resort } from './entities/resort.entity';

describe('ResortService', () => {
  let service: ResortService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({

      providers: [
        ResortService,
        {provide: getRepositoryToken(Resort), useValue: {}}
      ],
    }).compile();

    service = module.get<ResortService>(ResortService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });
});
