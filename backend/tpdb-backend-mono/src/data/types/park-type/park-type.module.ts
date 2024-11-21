import { Module } from '@nestjs/common';
import { ParkTypeService } from './park-type.service';
import { ParkTypeController } from './park-type.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ParkType } from './entities/park-type.entity';

@Module({
  imports: [TypeOrmModule.forFeature([ParkType])],
  controllers: [ParkTypeController],
  providers: [ParkTypeService],
})
export class ParkTypeModule {}
