import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PaginatedPark, Park} from '../../model/park/park.model';


@Injectable({
  providedIn: 'root'
})
export class ParkService {

  private baseUrl = '/api/v1/parks';

  constructor(private http: HttpClient) {
  }


  getAllParks(page: number, size: number): Observable<PaginatedPark> {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size)
    return this.http.get<PaginatedPark>(this.baseUrl, {params})
  }

  addPark(park: Park) {
    this.http.post<Park>(this.baseUrl, park);
  }
}
