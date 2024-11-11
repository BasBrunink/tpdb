import { MigrationInterface, QueryRunner } from 'typeorm';

export class CreateResort1731317749142 implements MigrationInterface {
  name = 'CreateResort1731317749142';

  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`CREATE TABLE "resort"
                             (
                                 "id"          integer GENERATED ALWAYS AS IDENTITY NOT NULL,
                                 "name"        character varying NOT NULL,
                                 "description" character varying NOT NULL,
                                 CONSTRAINT "PK_3ffd8452901535c70454d5fb38c" PRIMARY KEY ("id")
                             )`);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`DROP TABLE "resort"`);
  }

}
