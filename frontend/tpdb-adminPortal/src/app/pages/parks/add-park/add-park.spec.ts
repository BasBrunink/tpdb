import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPark } from './add-park';

describe('AddPark', () => {
  let component: AddPark;
  let fixture: ComponentFixture<AddPark>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddPark]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddPark);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
