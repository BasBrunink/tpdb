import { Column, Entity } from 'typeorm';
import { BaseModelWithLocation } from '../../../common/enitities/baseModelWithLocation.entity';

@Entity()
export class Ride extends BaseModelWithLocation {
  @Column()
  name: string;
}
