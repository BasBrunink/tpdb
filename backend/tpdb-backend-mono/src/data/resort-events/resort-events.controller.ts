import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
} from '@nestjs/common';
import { ResortEventsService } from './resort-events.service';
import { CreateResortEventDto } from './dto/create-resort-event.dto';
import { UpdateResortEventDto } from './dto/update-resort-event.dto';

@Controller('resort-events')
export class ResortEventsController {
  constructor(private readonly resortEventsService: ResortEventsService) {}

  @Post()
  create(@Body() createResortEventDto: CreateResortEventDto) {
    return this.resortEventsService.create(createResortEventDto);
  }

  @Get()
  findAll() {
    return this.resortEventsService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.resortEventsService.findOne(+id);
  }

  @Patch(':id')
  update(
    @Param('id') id: string,
    @Body() updateResortEventDto: UpdateResortEventDto,
  ) {
    return this.resortEventsService.update(+id, updateResortEventDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.resortEventsService.remove(+id);
  }
}
