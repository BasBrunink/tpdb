import { BaseModel } from '../../../common/enitities/baseModel.entity';
import { Column, Entity, ManyToOne } from 'typeorm';
import { Resort } from '../../resort/entities/resort.entity';

@Entity()
export class ResortInternalTransportation extends BaseModel {
  @Column()
  name: string;

  @ManyToOne(() => Resort, (resort) => resort.transportation)
  resort: Resort;
}
