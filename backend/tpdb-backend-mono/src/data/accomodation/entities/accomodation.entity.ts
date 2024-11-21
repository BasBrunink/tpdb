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
import { AccomodationType } from '../../types/accomodation-type/entities/accomodation-type.entity';
import { AccomodationAmenity } from '../accomodation-amenities/entities/accomodation-amenity.entity';
import { User } from '../../../authentication/user/entities/user.entity';

@Entity()
export class Accomodation {
  @PrimaryGeneratedColumn('uuid')
  id?: string;

  @Column({ nullable: true })
  createdAt: Date;

  @ManyToOne(() => User, { eager: true })
  @JoinColumn({ name: 'createUserId' })
  createdBy: User;

  @ManyToOne(() => User, { eager: true })
  @JoinColumn({ name: 'updateUserId' })
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

  @OneToOne(() => AccomodationType)
  @JoinColumn()
  accomodationType: AccomodationType;

  @Column()
  rating: number;

  @Column()
  priceRange: number;

  @Column()
  rooms: number;

  @Column()
  ContantInfo: string;

  @ManyToMany(() => AccomodationAmenity)
  @JoinTable({ name: 'accomodation_has_amenities' })
  amenities: AccomodationAmenity[];

  @ManyToOne(() => Resort, (resort) => resort.accommodations)
  resort: Resort;
}
