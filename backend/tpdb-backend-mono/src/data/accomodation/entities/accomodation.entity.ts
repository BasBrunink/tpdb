import { Column, Entity, JoinColumn, JoinTable, ManyToMany, ManyToOne, OneToOne } from 'typeorm';
import { Resort } from '../../resort/entities/resort.entity';
import { AccomodationType } from '../accomodation-type/entities/accomodation-type.entity';
import { AccomodationAmenity } from '../accomodation-amenities/entities/accomodation-amenity.entity';
import { BaseModelWithLocation } from '../../../common/enitities/baseModelWithLocation.entity';

@Entity()
export class Accomodation extends BaseModelWithLocation{

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
  priceRange : number;

  @Column()
  rooms: number;

  @Column()
  ContantInfo: string;


  @ManyToMany(() => AccomodationAmenity)
  @JoinTable({ name: 'accomodation_has_amenities' })
  amenities: AccomodationAmenity[];


  @ManyToOne(() => Resort, (resort) => resort.accomodations)
  resort: Resort;
}
