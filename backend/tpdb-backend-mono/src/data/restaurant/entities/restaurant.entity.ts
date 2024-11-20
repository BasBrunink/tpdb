import { BaseModelWithLocation } from '../../../common/enitities/baseModelWithLocation.entity';
import { Column, Entity, ManyToOne } from 'typeorm';
import { Resort } from '../../resort/entities/resort.entity';

@Entity()
export class Restaurant extends BaseModelWithLocation {
  @Column()
  name: string;

  @ManyToOne(() => Resort, (resort) => resort.restaurants)
  resort: Resort;
}
