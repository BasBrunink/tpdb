import { BaseModel } from '../../../../common/enitities/baseModel.entity';
import { Column, Entity } from 'typeorm';

@Entity()
export class AttractionType extends BaseModel {
  @Column()
  name: string;
  @Column()
  description: string;
}
