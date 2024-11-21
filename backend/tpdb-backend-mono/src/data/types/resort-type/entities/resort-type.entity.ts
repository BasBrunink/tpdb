import { Entity } from 'typeorm';
import { BaseModel } from '../../../../common/enitities/baseModel.entity';

@Entity()
export class ResortType extends BaseModel{

  type: string;
  description: string;

}
