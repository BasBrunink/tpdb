import { Column, Entity, JoinColumn, OneToMany, OneToOne } from 'typeorm';
import { BaseModelWithLocation } from '../../../common/enitities/baseModelWithLocation.entity';
import { Park } from '../../park/entities/park.entity';
import { Accomodation } from '../../accomodation/entities/accomodation.entity';
import { Restaurant } from '../../restaurant/entities/restaurant.entity';
import { ResortInternalTransportation } from '../../resort-internal-transportation/entities/resort-internal-transportation.entity';
import { Company } from '../../company/entities/company.entity';
import { ResortType } from '../../types/resort-type/entities/resort-type.entity';

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

  @Column({ nullable: true })
  seasonality: string;

  @Column({ nullable: true })
  dailyCapacity: number;

  @Column({ nullable: true })
  area: number;

  @OneToOne(() => ResortType)
  @JoinColumn()
  resortType: ResortType;

  @Column({ nullable: true })
  annualVisitors: number; // TODO maybe we want some history on this as wel.

  @Column({ nullable: true })
  entryFee: number; //TODO: maybe we want some history on this.

  @OneToOne(() => Company)
  @JoinColumn({ name: 'operator' })
  operator: Company;

  @OneToOne(() => Company)
  @JoinColumn({ name: 'owner' })
  owner: Company;

  @OneToMany(() => Park, (park) => park.resort)
  parks: Park[];

  @OneToMany(() => Restaurant, (restaurant) => restaurant.resort)
  restaurants: Restaurant[];

  @OneToMany(
    () => ResortInternalTransportation,
    (transport) => transport.resort,
  )
  transportation: ResortInternalTransportation[];
  @OneToMany(() => Accomodation, (accomodation) => accomodation.resort)
  accommodations: Accomodation[];
}
