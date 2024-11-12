import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { ParkTypeService } from './park-type.service';
import { CreateParkTypeDto } from './dto/create-park-type.dto';
import { UpdateParkTypeDto } from './dto/update-park-type.dto';

@Controller('park-type')
export class ParkTypeController {
  constructor(private readonly parkTypeService: ParkTypeService) {}

  @Post()
  create(@Body() createParkTypeDto: CreateParkTypeDto) {
    return this.parkTypeService.create(createParkTypeDto);
  }

  @Get()
  findAll() {
    return this.parkTypeService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.parkTypeService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateParkTypeDto: UpdateParkTypeDto) {
    return this.parkTypeService.update(+id, updateParkTypeDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.parkTypeService.remove(+id);
  }
}
