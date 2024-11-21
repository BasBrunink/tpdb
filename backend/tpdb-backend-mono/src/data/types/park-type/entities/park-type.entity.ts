import { Column, Entity } from 'typeorm';
import { BaseModel } from '../../../../common/enitities/baseModel.entity';

@Entity()
export class ParkType extends BaseModel {
  @Column({ unique: true})
  name: string;

  @Column({ nullable: true })
  description: string;
}
