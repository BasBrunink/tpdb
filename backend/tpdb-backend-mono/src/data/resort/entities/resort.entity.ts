import { Column, Entity, OneToMany } from 'typeorm';
import { BaseModelWithLocation } from '../../../common/enitities/baseModelWithLocation.entity';
import { Park } from '../../park/entities/park.entity';
import { Accomodation } from '../../accomodation/entities/accomodation.entity';
import { ResortAttraction } from '../../resort-attraction/entities/resort-attraction.entity';
import { Restaurant } from '../../restaurant/entities/restaurant.entity';

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

  @Column({ nullable: true })
  seasonality: string;

  @Column({ nullable: true })
  dailyCapacity: number;

  @OneToMany(() => Park, (park) => park.resort)
  parks: Park[];

  @OneToMany(() => ResortAttraction, (attraction) => attraction.resort)
  attractions: ResortAttraction[];

  @OneToMany(() => Restaurant, (restaurant) => restaurant.resort)
  restaurants: Restaurant[];
  @OneToMany(() => Accomodation, (accomodation) => accomodation.resort)
  accomodations: Accomodation[];
}
