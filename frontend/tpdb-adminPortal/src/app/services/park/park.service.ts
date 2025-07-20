import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {Park} from '../../model/park.model';


@Injectable({
  providedIn: 'root'
})
export class ParkService {

  private baseUrl = '/api/v1/parks';

  constructor(private http: HttpClient) { }


  getAllParks(page: number, size: number): Observable<any> {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size)
    return this.http.get<any>(this.baseUrl, {params})
  }

  addPark(park: Park) {
    let x = this.http.post<Park>(this.baseUrl, park);
}
}
