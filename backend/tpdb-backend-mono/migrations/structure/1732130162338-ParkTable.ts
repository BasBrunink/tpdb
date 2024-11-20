import { MigrationInterface, QueryRunner } from 'typeorm';

export class ParkTable1732130162338 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`
            create table public.park
            (
                id            uuid default uuid_generate_v4() not null
                    constraint "PK_653802406812552d8de5f9a4047"
                        primary key,
                "createdAt"   timestamp,
                "updatedAt"   timestamp,
                address       varchar,
                city          varchar,
                country       varchar,
                "gpsLong"     varchar,
                "gpsLat"      varchar,
                name          varchar                         not null,
                description   varchar                         not null,
                "openingDate" timestamp                       not null,
                "closingDate" timestamp,
                "parkTypeId"  uuid
                    constraint "REL_b72c3e6e1940f1f9ee6bf8ce1a"
                        unique
                    constraint "FK_b72c3e6e1940f1f9ee6bf8ce1a0"
                        references public.park_type,
                "resortId"    uuid
                    constraint "FK_3e4d357c4048908e3e59e32761e"
                        references public.resort
            );

        `);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`DROP TABLE "park"`);
  }
}
