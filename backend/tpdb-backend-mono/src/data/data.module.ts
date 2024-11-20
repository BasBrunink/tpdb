import { Module } from '@nestjs/common';
import { ResortModule } from './resort/resort.module';
import { ParkModule } from './park/park.module';
import { AccomodationModule } from './accomodation/accomodation.module';
import { AttractionModule } from './attraction/attraction.module';
import { RideModule } from './ride/ride.module';
import { ResortAttractionModule } from './resort-attraction/resort-attraction.module';
import { RestaurantModule } from './restaurant/restaurant.module';
import { ResortInternalTransportationModule } from './resort-internal-transportation/resort-internal-transportation.module';
import { TravelOptionModule } from './travel-option/travel-option.module';

@Module({
  imports: [ResortModule, ParkModule, AccomodationModule, AttractionModule, RideModule, ResortAttractionModule, RestaurantModule, ResortInternalTransportationModule, TravelOptionModule],
})
export class DataModule {}
