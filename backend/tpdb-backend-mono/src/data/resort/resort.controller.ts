import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { ResortService } from './resort.service';
import { CreateResortDto } from './dto/create-resort.dto';
import { UpdateResortDto } from './dto/update-resort.dto';

@Controller('resort')
export class ResortController {
  constructor(private readonly resortService: ResortService) {}

  @Post()
  create(@Body() createResortDto: CreateResortDto) {
    return this.resortService.create(createResortDto);
  }

  @Get()
  findAll() {
    return this.resortService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.resortService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateResortDto: UpdateResortDto) {
    return this.resortService.update(+id, updateResortDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.resortService.remove(+id);
  }
}
