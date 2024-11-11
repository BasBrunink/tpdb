import { Column, Entity, PrimaryGeneratedColumn } from 'typeorm';

@Entity()
export class Resort {
  @PrimaryGeneratedColumn('identity', {
    generatedIdentity: 'ALWAYS',
  })
  id: number;

  @Column()
  name: string;

  @Column()
  description: string;

  @Column()
  test: string;
}
