import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { ResortInternalTransportationService } from './resort-internal-transportation.service';
import { CreateResortInternalTransportationDto } from './dto/create-resort-internal-transportation.dto';
import { UpdateResortInternalTransportationDto } from './dto/update-resort-internal-transportation.dto';

@Controller('resort-internal-transportation')
export class ResortInternalTransportationController {
  constructor(private readonly resortInternalTransportationService: ResortInternalTransportationService) {}

  @Post()
  create(@Body() createResortInternalTransportationDto: CreateResortInternalTransportationDto) {
    return this.resortInternalTransportationService.create(createResortInternalTransportationDto);
  }

  @Get()
  findAll() {
    return this.resortInternalTransportationService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.resortInternalTransportationService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateResortInternalTransportationDto: UpdateResortInternalTransportationDto) {
    return this.resortInternalTransportationService.update(+id, updateResortInternalTransportationDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.resortInternalTransportationService.remove(+id);
  }
}
