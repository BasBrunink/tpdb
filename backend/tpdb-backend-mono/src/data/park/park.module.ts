import { Module } from '@nestjs/common';
import { ParkService } from './park.service';
import { ParkController } from './park.controller';
import { ParkTypeController } from './park-type/park-type.controller';
import { ParkTypeService } from './park-type/park-type.service';
import { ParkTypeModule } from './park-type/park-type.module';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Park } from './entities/park.entity';

@Module({
  imports: [
    TypeOrmModule.forFeature([Park]),
    ParkTypeModule],
  controllers: [ParkController],
  providers: [ParkService],
  exports: [ParkService],
})
export class ParkModule {}
