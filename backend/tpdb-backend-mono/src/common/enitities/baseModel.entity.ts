import { Column, JoinColumn, ManyToOne, PrimaryGeneratedColumn } from 'typeorm';
import { User } from '../../authentication/user/entities/user.entity';

export abstract class BaseModel {
  @PrimaryGeneratedColumn('uuid')
  id?: string;

  @Column({ nullable: true })
  createdAt: Date;

  @ManyToOne(() => User)
  @JoinColumn({ name: 'createUserId' })
  createdBy: User;

  @ManyToOne(() => User)
  @JoinColumn({ name: 'updateUserId' })
  updatedBy: User;

  @Column({ nullable: true })
  updatedAt: Date;

}
