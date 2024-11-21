import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { WikiPageService } from './wiki-page.service';
import { CreateWikiPageDto } from './dto/create-wiki-page.dto';
import { UpdateWikiPageDto } from './dto/update-wiki-page.dto';

@Controller('wiki-page')
export class WikiPageController {
  constructor(private readonly wikiPageService: WikiPageService) {}

  @Post()
  create(@Body() createWikiPageDto: CreateWikiPageDto) {
    return this.wikiPageService.create(createWikiPageDto);
  }

  @Get()
  findAll() {
    return this.wikiPageService.findAll();
  }

  @Get(':id')
  findOne(@Param('id') id: string) {
    return this.wikiPageService.findOne(+id);
  }

  @Patch(':id')
  update(@Param('id') id: string, @Body() updateWikiPageDto: UpdateWikiPageDto) {
    return this.wikiPageService.update(+id, updateWikiPageDto);
  }

  @Delete(':id')
  remove(@Param('id') id: string) {
    return this.wikiPageService.remove(+id);
  }
}
