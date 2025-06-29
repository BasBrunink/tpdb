import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Parks } from './parks';

describe('Parks', () => {
  let component: Parks;
  let fixture: ComponentFixture<Parks>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Parks]
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
