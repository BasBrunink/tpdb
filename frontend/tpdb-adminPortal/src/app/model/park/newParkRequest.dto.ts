import {ParkStatus, ParkType} from './park.model';
import {DateTime} from 'luxon';

export class newParkRequest {
  constructor(
    public name: string,
    public description: string,
    public parkType: ParkType,
    public openingDate: DateTime | null,
    public closingDate: DateTime | null,
    public parkStatus: ParkStatus,
    public address: string,
    public areaSize: number,
  ) {
  }
}
