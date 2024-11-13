import { Column, Entity } from 'typeorm';
import { BaseModel } from '../../../../common/enitities/baseModel.entity';

@Entity()
export class AccomodationType extends BaseModel {
  @Column()
  name: string;

  @Column()
  description: string;
}
