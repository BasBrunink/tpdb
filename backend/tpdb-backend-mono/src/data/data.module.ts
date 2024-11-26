import { Module } from '@nestjs/common';
import { ResortModule } from './resort/resort.module';
import { ParkModule } from './park/park.module';
import { AccommodationModule } from './accommodation/accommodation.module';
import { AttractionModule } from './attraction/attraction.module';
import { RideModule } from './ride/ride.module';
import { RestaurantModule } from './restaurant/restaurant.module';
import { ResortInternalTransportationModule } from './resort-internal-transportation/resort-internal-transportation.module';
import { TravelOptionModule } from './travel-option/travel-option.module';
import { CompanyModule } from './company/company.module';
import { ResortEventsModule } from './resort-events/resort-events.module';

@Module({
  imports: [
    ResortModule,
    ParkModule,
    AccommodationModule,
    AttractionModule,
    RideModule,
    RestaurantModule,
    ResortInternalTransportationModule,
    TravelOptionModule,
    CompanyModule,
    ResortEventsModule,
  ],
})
export class DataModule {}
