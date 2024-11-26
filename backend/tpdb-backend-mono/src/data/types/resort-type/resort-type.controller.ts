import {
  Body,
  ClassSerializerInterceptor,
  Controller,
  Delete,
  Get,
  Param,
  Patch,
  Post,
  Req,
  UseGuards,
  UseInterceptors,
} from '@nestjs/common';
import { ResortTypeService } from './resort-type.service';
import { CreateResortTypeDto } from './dto/create-resort-type.dto';
import { UpdateResortTypeDto } from './dto/update-resort-type.dto';
import { JwtAuthGuard } from '../../../authentication/auth/jwt.guard';

@Controller('resort-type')
export class ResortTypeController {
  constructor(private readonly resortTypeService: ResortTypeService) {}

  @UseGuards(JwtAuthGuard)
  @UseInterceptors(ClassSerializerInterceptor)
  @Post()
  create(@Body() createResortTypeDto: CreateResortTypeDto, @Req() req: any) {
    return this.resortTypeService.create(createResortTypeDto, req.user);
  }

  @UseInterceptors(ClassSerializerInterceptor)
  @Get()
  findAll() {
    return this.resortTypeService.findAll();
  }

  @UseInterceptors(ClassSerializerInterceptor)
  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.resortTypeService.findOne(id);
  }

  @UseGuards(JwtAuthGuard)
  @UseInterceptors(ClassSerializerInterceptor)
  @Patch(':id')
  update(
    @Param('id') id: string,
    @Body() updateResortTypeDto: UpdateResortTypeDto,
    @Req() req: any
  ) {
    return this.resortTypeService.update(id, updateResortTypeDto, req.user);
  }

  @UseGuards(JwtAuthGuard)
  @UseInterceptors(ClassSerializerInterceptor)
  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.resortTypeService.remove(id);
  }
}
