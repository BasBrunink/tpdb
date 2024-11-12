import { Module } from '@nestjs/common';
import { ParkTypeService } from './park-type.service';
import { ParkTypeController } from './park-type.controller';

@Module({
  controllers: [ParkTypeController],
  providers: [ParkTypeService],
})
export class ParkTypeModule {}
