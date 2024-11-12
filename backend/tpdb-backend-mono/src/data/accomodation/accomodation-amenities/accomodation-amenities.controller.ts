import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { AccomodationAmenitiesService } from './accomodation-amenities.service';
import { CreateAccomodationAmenityDto } from './dto/create-accomodation-amenity.dto';
import { UpdateAccomodationAmenityDto } from './dto/update-accomodation-amenity.dto';

@Controller('accomodation-amenities')
export class AccomodationAmenitiesController {
  constructor(private readonly accomodationAmenitiesService: AccomodationAmenitiesService) {}

  @Post()
  create(@Body() createAccomodationAmenityDto: CreateAccomodationAmenityDto) {
    return this.accomodationAmenitiesService.create(createAccomodationAmenityDto);
  }

  @Get()
  findAll() {
    return this.accomodationAmenitiesService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.accomodationAmenitiesService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateAccomodationAmenityDto: UpdateAccomodationAmenityDto) {
    return this.accomodationAmenitiesService.update(+id, updateAccomodationAmenityDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.accomodationAmenitiesService.remove(+id);
  }
}
