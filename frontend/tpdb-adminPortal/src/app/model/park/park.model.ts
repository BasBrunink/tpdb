import { DateTime } from 'luxon';

export enum ParkType {
  AMUSEMENTPARK = 'AMUSEMENTPARK',
  WATERPARK = 'WATERPARK',
  THEMEPARK = 'THEMEPARK',
  ANIMALPARK = 'ANIMALPARK'
}
export enum ParkStatus {
  'DEFUNCT',
  'OPERATING',
  'OUT_OF_OPERATION',
  'UNDER_CONSTRUCTION'
}

export class Park {
  constructor(
    public id: string,
    public created: DateTime,
    public updated: DateTime,
    public name: string,
    public description: string,
    public parkType: ParkType,

    public status: ParkStatus,
    public address: string,
    public areaSize: number,
    public opening: DateTime |null,
    public closing?: DateTime | null,
  ) {}

  static fromJson(json: any): Park
  {
    return new Park(
      json.id,
      DateTime.fromISO(json.created),
      DateTime.fromISO(json.updated),
      json.name,
      json.description,
      json.parkType,
      json.status,
      json.address,
      json.areaSize,
      DateTime.fromISO(json.opening),
      DateTime.fromISO(json.closing),
    );
  }}

export class PaginatedPark {
  constructor(
    public totalPages: number,
    public totalElements: number,
    public size: number,
    public content: Park[]
    ) {
  }
  static fromJson(json: any): PaginatedPark {
    return new PaginatedPark(json.totalPages, json.totalElements, json.size, json.content
    )
  }
}

