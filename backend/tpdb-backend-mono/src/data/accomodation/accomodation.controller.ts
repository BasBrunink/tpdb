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
import { CreateAccomodationDto } from './dto/create-accomodation.dto';
import { UpdateAccomodationDto } from './dto/update-accomodation.dto';

@Controller('accomodation')
export class AccomodationController {
  constructor(private readonly accomodationService: AccomodationService) {}

  @Post()
  create(@Body() createAccomodationDto: CreateAccomodationDto) {
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
    @Body() updateAccomodationDto: UpdateAccomodationDto,
  ) {
    return this.accomodationService.update(+id, updateAccomodationDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.accomodationService.remove(+id);
  }
}
