import { Module } from '@nestjs/common';
import { AccomodationAmenitiesService } from './accomodation-amenities.service';
import { AccomodationAmenitiesController } from './accomodation-amenities.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AccomodationAmenity } from './entities/accomodation-amenity.entity';

@Module({
  imports: [TypeOrmModule.forFeature([AccomodationAmenity])],
  controllers: [AccomodationAmenitiesController],
  providers: [AccomodationAmenitiesService],
})
export class AccomodationAmenitiesModule {}
