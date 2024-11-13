import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
} from '@nestjs/common';
import { AccomodationTypeService } from './accomodation-type.service';
import { CreateAccomodationTypeDto } from './dto/create-accomodation-type.dto';
import { UpdateAccomodationTypeDto } from './dto/update-accomodation-type.dto';

@Controller('accomodation-type')
export class AccomodationTypeController {
  constructor(
    private readonly accomodationTypeService: AccomodationTypeService,
  ) {}

  @Post()
  create(@Body() createAccomodationTypeDto: CreateAccomodationTypeDto) {
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
    @Body() updateAccomodationTypeDto: UpdateAccomodationTypeDto,
  ) {
    return this.accomodationTypeService.update(+id, updateAccomodationTypeDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.accomodationTypeService.remove(+id);
  }
}
