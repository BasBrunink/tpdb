import { TestBed } from '@angular/core/testing';

import { ParkService } from './park.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {HttpClientTestingModule} from '@angular/common/http/testing';

describe('ParkService', () => {
  let service: ParkService;

  beforeEach(() => {
    TestBed.configureTestingModule({imports: [HttpClientTestingModule]});
    service = TestBed.inject(ParkService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
