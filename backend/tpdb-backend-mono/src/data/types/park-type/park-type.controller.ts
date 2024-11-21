import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete, Req, UseGuards,
} from '@nestjs/common';
import { ParkTypeService } from './park-type.service';
import { CreateParkTypeDto } from './dto/create-park-type.dto';
import { UpdateParkTypeDto } from './dto/update-park-type.dto';
import { JwtAuthGuard } from '../../../authentication/auth/jwt.guard';

@Controller('park-type')
export class ParkTypeController {
  constructor(private readonly parkTypeService: ParkTypeService) {}

  @UseGuards(JwtAuthGuard)
  @Post()
  create(@Body() createParkTypeDto: CreateParkTypeDto, @Req() req: any) {
    return this.parkTypeService.create(createParkTypeDto, req.user);
  }

  @Get()
  findAll() {
    return this.parkTypeService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.parkTypeService.findOne(id);
  }

  @Patch(':id')
  update(
    @Param('id') id: string,
    @Body() updateParkTypeDto: UpdateParkTypeDto,
  ) {
    return this.parkTypeService.update(id, updateParkTypeDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.parkTypeService.remove(id);
  }
}
