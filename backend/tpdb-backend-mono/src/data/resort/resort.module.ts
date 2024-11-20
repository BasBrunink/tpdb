import { Module } from '@nestjs/common';
import { ResortService } from './resort.service';
import { ResortController } from './resort.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Resort } from './entities/resort.entity';
import { ResortTypeModule } from './resort-type/resort-type.module';

@Module({
  imports: [TypeOrmModule.forFeature([Resort]), ResortTypeModule],
  controllers: [ResortController],
  providers: [ResortService],
})
export class ResortModule {}
