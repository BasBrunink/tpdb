import { TestBed } from '@angular/core/testing';

import { MockParkService } from './mock-park-service';

describe('MockParkService', () => {
  let service: MockParkService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MockParkService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
