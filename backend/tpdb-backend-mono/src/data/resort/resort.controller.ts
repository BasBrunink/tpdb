import {
  Controller,
  Get,
  Post,
  Body,
  Patch,
  Param,
  Delete,
  UseGuards,
  Req,
} from '@nestjs/common';
import { ResortService } from './resort.service';
import { CreateResortDto } from './dto/create-resort.dto';
import { UpdateResortDto } from './dto/update-resort.dto';
import { JwtAuthGuard } from '../../authentication/auth/jwt.guard';

@Controller('resort')
export class ResortController {
  constructor(private readonly resortService: ResortService) {}

  @UseGuards(JwtAuthGuard)
  @Post()
  create(@Body() createResortDto: CreateResortDto, @Req() req: any) {
    return this.resortService.create(createResortDto, req.user);
  }

  @Get()
  findAll() {
    return this.resortService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.resortService.findOne(id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateResortDto: UpdateResortDto, @Req() req: any) {
    return this.resortService.update(id, updateResortDto, req.user);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.resortService.remove(id);
  }
}
