import { Resort } from '../../resort/entities/resort.entity';
import {
  Column,
  Entity,
  JoinColumn,
  ManyToOne,
  OneToOne,
  PrimaryGeneratedColumn,
} from 'typeorm';
import { ParkType } from '../../types/park-type/entities/park-type.entity';
import { User } from '../../../authentication/user/entities/user.entity';

@Entity()
export class Park {
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

  @OneToOne(() => ParkType)
  @JoinColumn()
  parkType: ParkType;

  @ManyToOne(() => Resort, (resort) => resort.parks)
  resort: Resort;
}
