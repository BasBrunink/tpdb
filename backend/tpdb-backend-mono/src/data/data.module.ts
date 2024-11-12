import { Module } from '@nestjs/common';
import { ResortModule } from './resort/resort.module';
import { ParkModule } from './park/park.module';

@Module({
  imports: [ResortModule, ParkModule],
})
export class DataModule {}
