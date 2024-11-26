import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
} from '@nestjs/common';
import { AccomodationService } from './accomodation.service';
import { CreateAccommodationDto } from './dto/create-accommodation.dto';
import { UpdateAccommodationDto } from './dto/update-accommodation.dto';

@Controller('accomodation')
export class AccommodationController {
  constructor(private readonly accomodationService: AccomodationService) {}

  @Post()
  create(@Body() createAccomodationDto: CreateAccommodationDto) {
    return this.accomodationService.create(createAccomodationDto);
  }

  @Get()
  findAll() {
    return this.accomodationService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.accomodationService.findOne(+id);
  }

  @Patch(':id')
  update(
    @Param('id') id: string,
    @Body() updateAccomodationDto: UpdateAccommodationDto,
  ) {
    return this.accomodationService.update(+id, updateAccomodationDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.accomodationService.remove(+id);
  }
}
