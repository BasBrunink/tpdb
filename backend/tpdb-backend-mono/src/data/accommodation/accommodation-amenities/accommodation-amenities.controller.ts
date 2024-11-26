import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
} from '@nestjs/common';
import { AccommodationAmenitiesService } from './accommodation-amenities.service';
import { CreateAccommodationAmenityDto } from './dto/create-accommodation-amenity.dto';
import { UpdateAccommodationAmenityDto } from './dto/update-accommodation-amenity.dto';

@Controller('accomodation-amenities')
export class AccommodationAmenitiesController {
  constructor(
    private readonly accomodationAmenitiesService: AccommodationAmenitiesService,
  ) {}

  @Post()
  create(@Body() createAccomodationAmenityDto: CreateAccommodationAmenityDto) {
    return this.accomodationAmenitiesService.create(
      createAccomodationAmenityDto,
    );
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
  update(
    @Param('id') id: string,
    @Body() updateAccomodationAmenityDto: UpdateAccommodationAmenityDto,
  ) {
    return this.accomodationAmenitiesService.update(
      +id,
      updateAccomodationAmenityDto,
    );
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.accomodationAmenitiesService.remove(+id);
  }
}
