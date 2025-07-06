import { DateTime } from 'luxon';

export type ParkType = 'AMUSEMENTPARK' | 'THEMEPARK' |'ANIMALPARK' | 'WATERPARK';
export type ParkStatus = 'DEFUNCT' | 'OPERATING' | 'OUT_OF_OPERATION' | 'UNDER_CONSTRUCTION';

export class Park {
  constructor(
    public id: string,
    public created: DateTime,
    public updated: DateTime,
    public name: string,
    public description: string,
    public parkType: ParkType,
    public opening: DateTime,
    public status: ParkStatus,
    public address: string,
    public areaSize: number,
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
      DateTime.fromISO(json.opening),
      json.status,
      json.address,
      json.areaSize,
      DateTime.fromISO(json.closing),
    );
  }}

