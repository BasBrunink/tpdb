import { MigrationInterface, QueryRunner } from 'typeorm';

export class Parktypes1731412806609 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`
        INSERT INTO "park_type" ("createdAt", "updatedAt", "name", "description")
        VALUES ('2024-11-12 00:00:00', '2024-11-12 00:00:00', 'Theme park',
                'Focuses on immersive themes, often around specific stories, characters, or locations. Examples include Disneyland and Universal Studios.'),
               ('2024-11-12 00:00:00', '2024-11-12 00:00:00', 'Amusement park',
                'Centers on rides and attractions without a specific theme, often focused on thrill rides like roller coasters and other amusement-style entertainment. Examples include Cedar Point and Six Flags.'),
               ('2024-11-12 00:00:00', '2024-11-12 00:00:00', 'Water park',
                'Features water-based attractions like slides, wave pools, and lazy rivers. Examples include Schlitterbahn and Aquatica.'),
               ('2024-11-12 00:00:00', '2024-11-12 00:00:00', 'Adventure park',
                'Offers outdoor activities like zip lines, rock climbing, and obstacle courses. Examples include Go Ape and TreeTop Adventure Park.'),
               ('2024-11-12 00:00:00', '2024-11-12 00:00:00', 'Family entertainment center',
                'Provides a variety of attractions like arcades, mini-golf, and laser tag. Examples include Chuck E. Cheese and Dave & Buster''s.'),
               ('2024-11-12 00:00:00', '2024-11-12 00:00:00', 'Animal park',
                'Focuses on animal exhibits and conservation efforts. Examples include the San Diego Zoo and the Australia Zoo.'),
               ('2024-11-12 00:00:00', '2024-11-12 00:00:00', 'Aquarium',
                'Displays marine life in tanks and exhibits. Examples include the Georgia Aquarium and the Monterey Bay Aquarium.');
    `);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`
        DELETE FROM "park_type" WHERE name = 'Theme park';
        DELETE FROM "park_type" WHERE name = 'Amusement park';
        DELETE FROM "park_type" WHERE name = 'Water park';
        DELETE FROM "park_type" WHERE name = 'Family entertainment center';
        DELETE FROM "park_type" WHERE name = 'Animal park';
        DELETE FROM "park_type" WHERE name = 'Aquarium';
    `);
  }
}
