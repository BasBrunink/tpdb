import { BaseModelWithLocation } from '../../../common/enitities/baseModelWithLocation.entity';
import { Resort } from '../../resort/entities/resort.entity';
import { Column, Entity, JoinColumn, ManyToOne, OneToOne } from 'typeorm';
import { ParkType } from '../../types/park-type/entities/park-type.entity';

@Entity()
export class Park extends BaseModelWithLocation {
  @Column()
  name: string;

  @Column()
  description: string;

  @Column()
  openingDate: Date;

  @Column({ nullable: true })
  closingDate: Date;

  @OneToOne(() => ParkType)
  @JoinColumn()
  parkType: ParkType;

  @ManyToOne(() => Resort, (resort) => resort.parks)
  resort: Resort;
}
