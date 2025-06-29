import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {Park} from '../../model/park.model';


@Injectable({
  providedIn: 'root'
})
export class ParkService {

  private baseUrl = '/api/v1/parks';

  constructor(private http: HttpClient) { }


  getAllParks(): Observable<Park[]> {
    return this.http.get<Park[]>(this.baseUrl).pipe(
      map(data => data.map(Park.fromJson))
    )
  }
}
