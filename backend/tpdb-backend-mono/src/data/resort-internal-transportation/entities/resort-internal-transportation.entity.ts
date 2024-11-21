import {
  Column,
  Entity,
  JoinColumn,
  ManyToOne,
  PrimaryGeneratedColumn,
} from 'typeorm';
import { Resort } from '../../resort/entities/resort.entity';
import { User } from '../../../authentication/user/entities/user.entity';

@Entity()
export class ResortInternalTransportation {
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

  @ManyToOne(() => Resort, (resort) => resort.transportation)
  resort: Resort;
}
