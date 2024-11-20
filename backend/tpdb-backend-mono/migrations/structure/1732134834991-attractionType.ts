import { MigrationInterface, QueryRunner } from 'typeorm';

export class AttractionType1732134834991 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`
        create table public.attraction_type
        (
            id          uuid default uuid_generate_v4() not null
                constraint "PK_b6e43ab56f092036419f477a9ea"
                    primary key,
            "createdAt" timestamp,
            "updatedAt" timestamp,
            name        varchar                         not null,
            description varchar                         not null
        );

        alter table public.attraction_type
            owner to dev;

    `);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`DROP TABLE "attraction_type"`);
  }
}
