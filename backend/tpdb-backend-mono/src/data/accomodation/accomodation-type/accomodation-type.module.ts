import { Module } from '@nestjs/common';
import { AccomodationTypeService } from './accomodation-type.service';
import { AccomodationTypeController } from './accomodation-type.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AccomodationType } from './entities/accomodation-type.entity';

@Module({
  imports: [TypeOrmModule.forFeature([AccomodationType])],
  controllers: [AccomodationTypeController],
  providers: [AccomodationTypeService],
})
export class AccomodationTypeModule {}
