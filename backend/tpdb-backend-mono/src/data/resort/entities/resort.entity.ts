import { Column, Entity } from 'typeorm';
import { BaseModelWithLocation } from '../../../common/baseModelWithLocation.entity';

@Entity()
export class Resort extends BaseModelWithLocation {
  constructor() {
    super();
  }
  @Column()
  name: string;

  @Column()
  description: string;

  @Column({ nullable: true })
  openingDate: string;

  @Column({ nullable: true })
  closingDate: string;
}
