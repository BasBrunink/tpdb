import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
  Req,
  UseGuards, UseInterceptors, ClassSerializerInterceptor,
} from '@nestjs/common';
import { ParkTypeService } from './park-type.service';
import { CreateParkTypeDto } from './dto/create-park-type.dto';
import { UpdateParkTypeDto } from './dto/update-park-type.dto';
import { JwtAuthGuard } from '../../../authentication/auth/jwt.guard';
import { ParkType } from './entities/park-type.entity';

@Controller('park-type')
export class ParkTypeController {
  constructor(private readonly parkTypeService: ParkTypeService) {}

  @UseGuards(JwtAuthGuard)
  @UseInterceptors(ClassSerializerInterceptor)
  @Post()
  create(@Body() createParkTypeDto: CreateParkTypeDto, @Req() req: any): Promise<ParkType> {
    return this.parkTypeService.create(createParkTypeDto, req.user);
  }

  @UseInterceptors(ClassSerializerInterceptor)
  @Get()
  findAll() {
    return this.parkTypeService.findAll();
  }
  @UseInterceptors(ClassSerializerInterceptor)
  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.parkTypeService.findOne(id);
  }

  @UseGuards(JwtAuthGuard)
  @UseInterceptors(ClassSerializerInterceptor)
  @Patch(':id')
  update(
    @Param('id') id: string,
    @Body() updateParkTypeDto: UpdateParkTypeDto,
    @Req() req: any
  ) {
    return this.parkTypeService.update(id, updateParkTypeDto, req.user);
  }
  @UseGuards(JwtAuthGuard)
  @UseInterceptors(ClassSerializerInterceptor)
  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.parkTypeService.remove(id);
  }
}
