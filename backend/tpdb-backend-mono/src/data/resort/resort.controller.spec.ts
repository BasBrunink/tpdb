import { Test, TestingModule } from '@nestjs/testing';
import { ResortController } from './resort.controller';
import { ResortService } from './resort.service';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Resort } from './entities/resort.entity';

describe('ResortController', () => {
  let controller: ResortController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [ResortController],
      providers: [{ provide: ResortService, useValue: {}}],
    }).compile();

    controller = module.get<ResortController>(ResortController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
