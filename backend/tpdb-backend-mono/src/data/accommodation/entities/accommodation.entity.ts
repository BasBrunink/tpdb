import {
  Column,
  Entity,
  JoinColumn,
  JoinTable,
  ManyToMany,
  ManyToOne,
  OneToOne,
  PrimaryGeneratedColumn,
} from 'typeorm';
import { Resort } from '../../resort/entities/resort.entity';
import { AccommodationType   } from '../../types/accommodation-type/entities/accommodation-type.entity';

import { User } from '../../../authentication/user/entities/user.entity';
import { AccommodationAmenity } from '../accommodation-amenities/entities/accommodation-amenity.entity';

@Entity()
export class Accommodation {
  @PrimaryGeneratedColumn('uuid')
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

  @Column()
  openingDate: Date;

  @Column({ nullable: true })
  closingDate: Date;

  @OneToOne(() => AccommodationType)
  @JoinColumn()
  accomodationType: AccommodationType;

  @Column()
  rating: number;

  @Column()
  priceRange: number;

  @Column()
  rooms: number;

  @Column()
  ContantInfo: string;

  @ManyToMany(() => AccommodationAmenity)
  @JoinTable({ name: 'accomodation_has_amenities' })
  amenities: AccommodationAmenity[];

  @ManyToOne(() => Resort, (resort) => resort.accommodations)
  resort: Resort;
}
