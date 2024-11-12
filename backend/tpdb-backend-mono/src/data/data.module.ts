import { Module } from '@nestjs/common';
import { ResortModule } from './resort/resort.module';
import { ParkModule } from './park/park.module';
import { AccomodationModule } from './accomodation/accomodation.module';

@Module({
  imports: [ResortModule, ParkModule, AccomodationModule],
})
export class DataModule {}
