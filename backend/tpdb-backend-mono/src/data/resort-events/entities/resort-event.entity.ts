import { Column, Entity } from 'typeorm';
import { BaseModel } from '../../../common/enitities/baseModel.entity';

@Entity()
export class ResortEvent extends BaseModel {
  @Column()
  name: string;
}
