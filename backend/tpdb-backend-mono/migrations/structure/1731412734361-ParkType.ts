import { MigrationInterface, QueryRunner } from "typeorm";

export class ParkType1731412734361 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`CREATE TABLE "park_type"
                             (
                                 "id" uuid NOT NULL DEFAULT uuid_generate_v4(),
                                 "createdAt"   TIMESTAMP,
                                 "updatedAt"   TIMESTAMP,
                                 "name"        character varying NOT NULL,
                                 "description" character varying NOT NULL,
                                 CONSTRAINT "PK_700e73e324dd20a8b109cb1a187" PRIMARY KEY ("id")
                             )`);
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`DROP TABLE "park_type"`);
    }

}
