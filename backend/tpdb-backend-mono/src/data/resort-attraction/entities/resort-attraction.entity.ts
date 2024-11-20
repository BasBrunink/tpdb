import { BaseModelWithLocation } from '../../../common/enitities/baseModelWithLocation.entity';
import { Column, ManyToOne } from 'typeorm';
import { Resort } from '../../resort/entities/resort.entity';

export class ResortAttraction extends BaseModelWithLocation {
  @Column()
  name: string;

  @ManyToOne(() => Resort, (Resort) => Resort.attractions)
  resort: Resort;
}
