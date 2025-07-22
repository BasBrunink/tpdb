import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddParkForm } from './add-park-form';

describe('AddParkForm', () => {
  let component: AddParkForm;
  let fixture: ComponentFixture<AddParkForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddParkForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddParkForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
