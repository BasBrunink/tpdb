import { Module } from '@nestjs/common';
import { AccomodationTypeService } from './accomodation-type.service';
import { AccomodationTypeController } from './accomodation-type.controller';

@Module({
  controllers: [AccomodationTypeController],
  providers: [AccomodationTypeService],
})
export class AccomodationTypeModule {}
