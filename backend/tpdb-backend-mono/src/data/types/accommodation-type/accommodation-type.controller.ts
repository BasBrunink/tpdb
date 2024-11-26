import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
} from '@nestjs/common';
import { AccommodationTypeService } from './accommodation-type.service';
import { CreateAccommodationTypeDto } from './dto/create-accommodation-type.dto';
import { UpdateAccommodationTypeDto } from './dto/update-accommodation-type.dto';

@Controller('accomodation-type')
export class AccommodationTypeController {
  constructor(
    private readonly accomodationTypeService: AccommodationTypeService,
  ) {}

  @Post()
  create(@Body() createAccomodationTypeDto: CreateAccommodationTypeDto) {
    return this.accomodationTypeService.create(createAccomodationTypeDto);
  }

  @Get()
  findAll() {
    return this.accomodationTypeService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.accomodationTypeService.findOne(+id);
  }

  @Patch(':id')
  update(
    @Param('id') id: string,
    @Body() updateAccomodationTypeDto: UpdateAccommodationTypeDto,
  ) {
    return this.accomodationTypeService.update(+id, updateAccomodationTypeDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.accomodationTypeService.remove(+id);
  }
}
