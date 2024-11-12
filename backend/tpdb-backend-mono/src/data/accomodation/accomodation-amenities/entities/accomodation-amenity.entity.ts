import { Column, Entity } from 'typeorm';
import { BaseModel } from '../../../../common/enitities/baseModel.entity';

@Entity()
export class AccomodationAmenity extends BaseModel {
  @Column()
  name: string;

  @Column()
  description: string;

  @Column()
  icon: string;



}

