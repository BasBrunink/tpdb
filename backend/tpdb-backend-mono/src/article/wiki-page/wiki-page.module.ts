import { Module } from '@nestjs/common';
import { WikiPageService } from './wiki-page.service';
import { WikiPageController } from './wiki-page.controller';

@Module({
  controllers: [WikiPageController],
  providers: [WikiPageService],
})
export class WikiPageModule {}
