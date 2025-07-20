import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Parks } from './parks';
import {HttpClientTestingModule} from '@angular/common/http/testing';

describe('Parks', () => {
  let component: Parks;
  let fixture: ComponentFixture<Parks>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Parks, HttpClientTestingModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Parks);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
