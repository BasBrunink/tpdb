import { Injectable } from '@nestjs/common';
import { CreateWikiPageDto } from './dto/create-wiki-page.dto';
import { UpdateWikiPageDto } from './dto/update-wiki-page.dto';

@Injectable()
export class WikiPageService {
  create(createWikiPageDto: CreateWikiPageDto) {
    return 'This action adds a new wikiPage';
  }

  findAll() {
    return `This action returns all wikiPage`;
  }

  findOne(id: number) {
    return `This action returns a #${id} wikiPage`;
  }

  update(id: number, updateWikiPageDto: UpdateWikiPageDto) {
    return `This action updates a #${id} wikiPage`;
  }

  remove(id: number) {
    return `This action removes a #${id} wikiPage`;
  }
}
