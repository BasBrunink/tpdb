import {
  Column,
  Entity,
  JoinColumn,
  ManyToOne,
  OneToMany,
  OneToOne,
  PrimaryGeneratedColumn,
} from 'typeorm';

import { Park } from '../../park/entities/park.entity';

import { Restaurant } from '../../restaurant/entities/restaurant.entity';
import { ResortInternalTransportation } from '../../resort-internal-transportation/entities/resort-internal-transportation.entity';
import { Company } from '../../company/entities/company.entity';
import { ResortType } from '../../types/resort-type/entities/resort-type.entity';
import { User } from '../../../authentication/user/entities/user.entity';
import { Accommodation } from '../../accommodation/entities/accommodation.entity';

@Entity()
export class Resort {
  @PrimaryGeneratedColumn('uuid')ccc
  id?: string;

  @Column({ nullable: true })
  createdAt: Date;

  @ManyToOne(() => User, { eager: true })
  @JoinColumn({ name: 'createUser' })
  createdBy: User;

  @ManyToOne(() => User, { eager: true })
  @JoinColumn({ name: 'updateUser' })
  updatedBy: User;

  @Column({ nullable: true })
  updatedAt: Date;
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
  @OneToMany(() => Accommodation, (accommodation) => accommodation.resort)
  accommodations: Accommodation[];
}
