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
});
