import { Column, Entity, JoinColumn, ManyToOne, PrimaryGeneratedColumn } from 'typeorm';

import { User } from '../../../../authentication/user/entities/user.entity';

@Entity()
export class ParkType {
  @PrimaryGeneratedColumn('uuid')
  id?: string;

  @Column({ nullable: true, type: 'timestamp' })
  createdAt: Date;

  @ManyToOne(() => User, { eager: true })
  @JoinColumn({ name: 'createUserId' })
  createdBy: User;

  @ManyToOne(() => User, { eager: true })
  @JoinColumn({ name: 'updateUserId' })
  updatedBy: User;

  @Column({ nullable: true, type: 'timestamp' })
  updatedAt: Date;
  @Column({ unique: true })
  type: string;

  @Column({ nullable: true, type: 'text' })
  description: string;
}
