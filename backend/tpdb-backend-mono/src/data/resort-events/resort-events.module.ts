import { Module } from '@nestjs/common';
import { ResortEventsService } from './resort-events.service';
import { ResortEventsController } from './resort-events.controller';

@Module({
  controllers: [ResortEventsController],
  providers: [ResortEventsService],
})
export class ResortEventsModule {}
