import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewParkDialog } from './new-park-dialog';

describe('NewParkDialog', () => {
  let component: NewParkDialog;
  let fixture: ComponentFixture<NewParkDialog>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewParkDialog]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewParkDialog);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
