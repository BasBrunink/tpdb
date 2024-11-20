import { BaseModelWithLocation } from '../../../common/enitities/baseModelWithLocation.entity';
import { Column, Entity } from 'typeorm';

@Entity()
export class Company extends BaseModelWithLocation {
  @Column()
  name: string;
}
