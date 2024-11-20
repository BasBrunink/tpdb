import { Module } from '@nestjs/common';
import { ResortInternalTransportationService } from './resort-internal-transportation.service';
import { ResortInternalTransportationController } from './resort-internal-transportation.controller';

@Module({
  controllers: [ResortInternalTransportationController],
  providers: [ResortInternalTransportationService],
})
export class ResortInternalTransportationModule {}
