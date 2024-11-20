import { MigrationInterface, QueryRunner } from 'typeorm';

export class ParkDummySeed1732130330582 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`

            INSERT INTO public.park ("createdAt", "updatedAt", address, city, country, "gpsLong", "gpsLat", name,
                                     description,
                                     "openingDate", "closingDate", "parkTypeId", "resortId")
            VALUES ('2024-11-20 20:19:30.000000', '2024-11-20 20:19:34.000000', 'Europa-Park-Strasse 2', 'Rust',
                    'Germany', '48.266014','7.721880', 'Europa Park', 'Theme park operated by the Mack Family', '1975,07,12 00:00:00.000000', null, null, null);
        `);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`DELETE
                             FROM "park"
                             WHERE name = 'Europa Park'`);
  }
}
