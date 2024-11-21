import { Test, TestingModule } from '@nestjs/testing';
import { ResortInternalTransportationController } from './resort-internal-transportation.controller';
import { ResortInternalTransportationService } from './resort-internal-transportation.service';

describe('ResortInternalTransportationController', () => {
  let controller: ResortInternalTransportationController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [ResortInternalTransportationController],
      providers: [ResortInternalTransportationService],
    }).compile();

    controller = module.get<ResortInternalTransportationController>(
      ResortInternalTransportationController,
    );
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
