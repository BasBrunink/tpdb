import { Module } from '@nestjs/common';
import { ResortTypeService } from './resort-type.service';
import { ResortTypeController } from './resort-type.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ResortType } from './entities/resort-type.entity';

@Module({
  imports: [TypeOrmModule.forFeature([ResortType])],
  controllers: [ResortTypeController],
  providers: [ResortTypeService],
})
export class ResortTypeModule {}
