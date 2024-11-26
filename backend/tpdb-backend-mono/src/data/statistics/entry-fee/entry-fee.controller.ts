import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { EntryFeeService } from './entry-fee.service';
import { CreateEntryFeeDto } from './dto/create-entry-fee.dto';
import { UpdateEntryFeeDto } from './dto/update-entry-fee.dto';

@Controller('entry-fee')
export class EntryFeeController {
  constructor(private readonly entryFeeService: EntryFeeService) {}

  @Post()
  create(@Body() createEntryFeeDto: CreateEntryFeeDto) {
    return this.entryFeeService.create(createEntryFeeDto);
  }

  @Get()
  findAll() {
    return this.entryFeeService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.entryFeeService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateEntryFeeDto: UpdateEntryFeeDto) {
    return this.entryFeeService.update(+id, updateEntryFeeDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.entryFeeService.remove(+id);
  }
}
