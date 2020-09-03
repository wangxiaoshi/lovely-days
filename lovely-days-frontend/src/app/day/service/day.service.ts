import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Day} from '../model/Day';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DayService {

  constructor(private httpClient: HttpClient) { }

  getDayList(): Observable<Day[]> {
    return this.httpClient.get<Day[]>(environment.apiUrl + `/day`);
  }

}
