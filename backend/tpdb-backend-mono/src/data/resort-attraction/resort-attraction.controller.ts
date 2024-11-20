import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { ResortAttractionService } from './resort-attraction.service';
import { CreateResortAttractionDto } from './dto/create-resort-attraction.dto';
import { UpdateResortAttractionDto } from './dto/update-resort-attraction.dto';

@Controller('resort-attraction')
export class ResortAttractionController {
  constructor(private readonly resortAttractionService: ResortAttractionService) {}

  @Post()
  create(@Body() createResortAttractionDto: CreateResortAttractionDto) {
    return this.resortAttractionService.create(createResortAttractionDto);
  }

  @Get()
  findAll() {
    return this.resortAttractionService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.resortAttractionService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateResortAttractionDto: UpdateResortAttractionDto) {
    return this.resortAttractionService.update(+id, updateResortAttractionDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.resortAttractionService.remove(+id);
  }
}
