export class CreateResortDto {
  name: string;
  description: string;
  openingDate?: Date;
  closingDate?: Date;
  seasonality?: string;
  dailyCapacity?: number;
  area?: number;
  resortTypeId: string;
  operatorId?: string;
  ownerId?: string;


}
