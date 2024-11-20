import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { TravelOptionService } from './travel-option.service';
import { CreateTravelOptionDto } from './dto/create-travel-option.dto';
import { UpdateTravelOptionDto } from './dto/update-travel-option.dto';

@Controller('travel-option')
export class TravelOptionController {
  constructor(private readonly travelOptionService: TravelOptionService) {}

  @Post()
  create(@Body() createTravelOptionDto: CreateTravelOptionDto) {
    return this.travelOptionService.create(createTravelOptionDto);
  }

  @Get()
  findAll() {
    return this.travelOptionService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.travelOptionService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateTravelOptionDto: UpdateTravelOptionDto) {
    return this.travelOptionService.update(+id, updateTravelOptionDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.travelOptionService.remove(+id);
  }
}
