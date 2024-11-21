import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { AttractionTypeService } from './attraction-type.service';
import { CreateAttractionTypeDto } from './dto/create-attraction-type.dto';
import { UpdateAttractionTypeDto } from './dto/update-attraction-type.dto';

@Controller('attraction-type')
export class AttractionTypeController {
  constructor(private readonly attractionTypeService: AttractionTypeService) {}

  @Post()
  create(@Body() createAttractionTypeDto: CreateAttractionTypeDto) {
    return this.attractionTypeService.create(createAttractionTypeDto);
  }

  @Get()
  findAll() {
    return this.attractionTypeService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.attractionTypeService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateAttractionTypeDto: UpdateAttractionTypeDto) {
    return this.attractionTypeService.update(+id, updateAttractionTypeDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.attractionTypeService.remove(+id);
  }
}
