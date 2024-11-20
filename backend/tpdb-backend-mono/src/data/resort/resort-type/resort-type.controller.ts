import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { ResortTypeService } from './resort-type.service';
import { CreateResortTypeDto } from './dto/create-resort-type.dto';
import { UpdateResortTypeDto } from './dto/update-resort-type.dto';

@Controller('resort-type')
export class ResortTypeController {
  constructor(private readonly resortTypeService: ResortTypeService) {}

  @Post()
  create(@Body() createResortTypeDto: CreateResortTypeDto) {
    return this.resortTypeService.create(createResortTypeDto);
  }

  @Get()
  findAll() {
    return this.resortTypeService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.resortTypeService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateResortTypeDto: UpdateResortTypeDto) {
    return this.resortTypeService.update(+id, updateResortTypeDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.resortTypeService.remove(+id);
  }
}
