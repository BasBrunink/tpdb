import { MigrationInterface, QueryRunner, Table } from 'typeorm';

export class AttractionTypes1732134967218 implements MigrationInterface {
  public async up(queryRunner: QueryRunner): Promise<void> {
    await queryRunner.query(`
        INSERT INTO "attraction_type" ("createdAt", "updatedAt", "name", "description")
        VALUES ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'playGround', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Exhibit', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Escape room', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Scavenger hunt', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'VR experience', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Augmented Reality Game', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Character meet and greet', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Fountain', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Mini Golf course', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Bowling alley', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Arcade', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Sports field', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Rock Climbing wall', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Hiking trail', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'BirdWatching area', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Scenic overlook', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Garden', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Workshop', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Science center', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Cultural exhibition', 'lorem'),
               ('2024-11-20 00:00:00', '2024-11-20 00:00:00', 'Behnd the scenes tour', 'lorem');
    `);
  }

  public async down(queryRunner: QueryRunner): Promise<void> {}
}
