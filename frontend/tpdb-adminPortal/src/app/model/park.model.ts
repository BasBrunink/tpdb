import { DateTime } from 'luxon';

export type ParkType = 'THEME_PARK' | 'WATER_PARK' | 'SHOPPING_DISTRICT'; // update with your enum values
export type ParkStatus = 'OPEN' | 'CLOSED' | 'SEASONAL'; // update with your enum values

export class Park {
  constructor(
    public id: string,
    public created: DateTime,
    public updated: DateTime,
    public name: string,
    public description: string,
    public parkType: ParkType,
    public opening: DateTime,
    public closing: DateTime,
    public status: ParkStatus,
    public address: string,
    public areaSize: number
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
      DateTime.fromISO(json.closing),
      json.status,
      json.address,
      json.areaSize
    );
  }}

