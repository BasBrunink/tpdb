import { Module } from '@nestjs/common';
import { ResortInternalTransportationService } from './resort-internal-transportation.service';
import { ResortInternalTransportationController } from './resort-internal-transportation.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ResortInternalTransportation } from './entities/resort-internal-transportation.entity';

@Module({
  imports: [TypeOrmModule.forFeature([ResortInternalTransportation])],
  controllers: [ResortInternalTransportationController],
  providers: [ResortInternalTransportationService],
})
export class ResortInternalTransportationModule {}
