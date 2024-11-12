import { Module } from '@nestjs/common';
import { AccomodationAmenitiesService } from './accomodation-amenities.service';
import { AccomodationAmenitiesController } from './accomodation-amenities.controller';

@Module({
  controllers: [AccomodationAmenitiesController],
  providers: [AccomodationAmenitiesService],
})
export class AccomodationAmenitiesModule {}
