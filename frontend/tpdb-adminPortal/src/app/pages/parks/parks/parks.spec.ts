import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Parks } from './parks';
import {HttpClientTestingModule} from '@angular/common/http/testing';
import {TranslateModule} from '@ngx-translate/core';
import {Park, ParkType, ParkStatus} from '../../../model/park/park.model';
import {ParkService} from '../../../services/park/park.service';
import {of} from 'rxjs';
import {DateTime} from 'luxon';
import {PageEvent} from '@angular/material/paginator';

// Mocks
const mockParks: Park[] = [
  {
    id: '1',
    name: 'Test Park',
    parkType: 'THEMEPARK' as ParkType,
    status: 'OPEN' as ParkStatus,
    opening: DateTime.fromObject({year: 2020, month: 1, day: 1}),
    closing: DateTime.fromObject({year: 2030, month: 12, day: 30}),
    created: DateTime.fromObject({year: 2020, month: 1, day: 1}),
    updated: DateTime.fromObject({year: 2020, month: 1, day: 1}),
    description: '',
    address: '',
    areaSize: 0
  },
  {
    id: '2',
    name: 'Future Park',
    parkType: 'THEMEPARK' as ParkType,
    status: 'OPEN' as ParkStatus,
    opening: DateTime.fromObject({year: 2020, month: 1, day: 1}),
    closing: null,
    created: DateTime.fromObject({year: 2020, month: 1, day: 1}),
    updated: DateTime.fromObject({year: 2020, month: 1, day: 1}),
    description: '',
    address: '',
    areaSize: 0
  },
  {
    id: '3',
    name: 'Future Park',
    parkType: 'THEMEPARK' as ParkType,
    status: 'UNDER_CONSTRUCTION' as ParkStatus,
    opening: null,
    closing: null,
    created: DateTime.fromObject({year: 2020, month: 1, day: 1}),
    updated: DateTime.fromObject({year: 2020, month: 1, day: 1}),
    description: '',
    address: '',
    areaSize: 0
  }
];

// Mocked service
const parkServiceMock = {
  getAllParks: jasmine.createSpy('getAllParks').and.returnValue(of({
    content: mockParks,
    totalElements: mockParks.length
  }))
};

describe('Parks', () => {
  let component: Parks;
  let fixture: ComponentFixture<Parks>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Parks, HttpClientTestingModule, TranslateModule.forRoot()],
      providers: [
        { provide: ParkService, useValue: parkServiceMock }
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Parks);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should load parks on init', () => {
    component.ngOnInit();
    expect(parkServiceMock.getAllParks).toHaveBeenCalledWith(0, 10);
    expect(component.parks.length).toBe(3);
    expect(component.totalElements).toBe(3);
  });

  it('should update pagination and reload parks on page change', () => {
    const event: PageEvent = { pageIndex: 1, pageSize: 20, length: 0 };
    component.onPageChange(event);
    expect(component.pageindex).toBe(1);
    expect(component.pagesize).toBe(20);
    expect(parkServiceMock.getAllParks).toHaveBeenCalledWith(1, 20);
  });

  it('should toggle expanded row correctly', () => {
    const park = mockParks[0];
    component.toggleRow(park);
    expect(component.expandedElement).toEqual(park);

    component.toggleRow(park);
    expect(component.expandedElement).toBeNull();
  });

  it('should return formatted opening date if available', () => {
    const result = component.getOpeningDateDisplay(mockParks[0]);
    expect(result).toBe('01-01-2020');
  });

  it('should return fallback opening message for under-construction park with no date', () => {
    const result = component.getOpeningDateDisplay(mockParks[2]);
    expect(result).toBe('no opening date yet');
  });

  it('should return formatted closing date if available', () => {
    const closingPark = mockParks[0]
    const result = component.getClosingDateDisplay(closingPark);
    expect(result).toBe('30-12-2030');
  });

  it('should return empty string if no closing date', () => {
    const result = component.getClosingDateDisplay(mockParks[1]);
    expect(result).toBe('');
  });

  it('should return correct translation key for park type', () => {
    const result = component.determineTranslationKeyForParkType('THEMEPARK' as ParkType,);
    expect(result).toBe('enum.parktype.THEMEPARK');
  });

  it('should return correct translation key for park status', () => {
    const result = component.determineTranslationKeyForParkStatus('OPEN' as ParkStatus);
    expect(result).toBe('enum.parkstatus.OPEN');
  });


});
