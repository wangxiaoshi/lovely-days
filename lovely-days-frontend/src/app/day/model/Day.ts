import {DayType} from './DayType';

export interface Day {

  id: bigint;
  name: string;
  date: Date;
  description: string;
  imageUrl: string;
  type: DayType;
}
