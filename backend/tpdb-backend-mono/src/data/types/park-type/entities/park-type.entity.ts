import {
  Column,
  Entity,
  JoinColumn,
  ManyToOne,
  PrimaryGeneratedColumn,
} from 'typeorm';

import { User } from '../../../../authentication/user/entities/user.entity';

@Entity()
export class ParkType {
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
  @Column({ unique: true })
  name: string;

  @Column({ nullable: true })
  description: string;
}
