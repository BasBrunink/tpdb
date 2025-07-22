import { TestBed } from '@angular/core/testing';

import { ParkService } from './park.service';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {Park, PaginatedPark, ParkStatus, ParkType} from '../../model/park/park.model';

describe('ParkService', () => {
  let service: ParkService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ParkService]
    });
    service = TestBed.inject(ParkService);
    httpMock = TestBed.inject(HttpTestingController)
  });

  afterEach(() => {
    httpMock.verify();
  })

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  describe('#getAllParks', () => {
    it('should perform GET request and return PaginatedPark', () => {
      const mockResponse: PaginatedPark = {
        content: [
          {id: '1', name: 'Test Park', parkType: 'THEMEPARK' as ParkType, status: 'OPEN' as ParkStatus} as unknown as Park,
        ],
        totalElements: 1,
        totalPages: 0,
        size: 0
      };

      service.getAllParks(0, 10).subscribe(res => {
        expect(res).toEqual(mockResponse);
        expect(res.content.length).toBe(1);
      });

      const req = httpMock.expectOne(req =>
        req.method === 'GET' &&
        req.url === '/api/v1/parks' &&
        req.params.get('page') === '0' &&
        req.params.get('size') === '10'
      );

      expect(req.request.method).toBe('GET');
      req.flush(mockResponse);
    });
  });
  describe('DeleteParkById', () => {
    it('should perform DELETE request and return 204', () =>{
      const parkId = '123e4567-e89b-12d3-a456-426614174000';
      service.deleteById(parkId).subscribe( res => {
        expect(res).toBeNull()
      })

      const req = httpMock.expectOne(`/api/v1/parks/${parkId}`)
      expect(req.request.method).toBe('DELETE');
      req.flush(null);

    })
  })
});
