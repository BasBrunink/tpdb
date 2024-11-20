import { BaseModelWithLocation } from '../../../common/enitities/baseModelWithLocation.entity';
import { Column, ManyToOne } from 'typeorm';
import { Res } from '@nestjs/common';
import { Resort } from '../../resort/entities/resort.entity';

export class Restaurant extends BaseModelWithLocation {
  @Column()
  name: string;

  @ManyToOne(() => Resort, (resort) => resort.restaurants)
  resort: Resort;
}
