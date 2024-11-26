import { Module } from '@nestjs/common';
import { AccommodationTypeService } from './accommodation-type.service';
import { AccommodationTypeController } from './accommodation-type.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { AccommodationType } from './entities/accommodation-type.entity';

@Module({
  imports: [TypeOrmModule.forFeature([AccommodationType])],
  controllers: [AccommodationTypeController],
  providers: [AccommodationTypeService],
})
export class AccommodationTypeModule {}
