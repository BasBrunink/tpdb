import { Module } from '@nestjs/common';
import { AccomodationService } from './accomodation.service';
import { AccommodationController } from './accommodation.controller';
import { AccommodationAmenitiesModule } from './accommodation-amenities/accommodation-amenities.module';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Accommodation } from './entities/accommodation.entity';

@Module({
  controllers: [AccommodationController],
  providers: [AccomodationService],
  imports: [
    TypeOrmModule.forFeature([Accommodation]),
    AccommodationAmenitiesModule,
  ],
})
export class AccommodationModule {}
