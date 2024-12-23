import { Column, Entity, OneToMany } from 'typeorm';
import { BaseModelWithLocation } from '../../../common/enitities/baseModelWithLocation.entity';
import { Park } from '../../park/entities/park.entity';
import { Accomodation } from '../../accomodation/entities/accomodation.entity';

@Entity()
export class Resort extends BaseModelWithLocation {
  constructor() {
    super();
  }
  @Column()
  name: string;

  @Column()
  description: string;

  @Column()
  openingDate: string;

  @Column({ nullable: true })
  closingDate: string;

  @OneToMany(() => Park, (park) => park.resort)
  parks: Park[];

  @OneToMany(() => Accomodation, (accomodation) => accomodation.resort)
  accomodations: Accomodation[];
}
