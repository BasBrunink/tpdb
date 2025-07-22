import {Component, inject} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {FormControl, FormGroup, ReactiveFormsModule} from '@angular/forms';
import {ParkStatus, ParkType} from '../../model/park/park.model';
import {DateTime} from 'luxon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {TranslatePipe} from '@ngx-translate/core';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from '@angular/material/datepicker';



@Component({
  selector: 'app-new-park-dialog',
  imports: [ReactiveFormsModule, MatFormFieldModule, TranslatePipe, MatInputModule, MatSelectModule, MatDatepickerToggle, MatDatepicker, MatDatepickerInput],
  templateUrl: './new-park-dialog.html',
  styleUrl: './new-park-dialog.scss'
})
export class NewParkDialog {

  readonly dialogRef = inject(MatDialogRef<NewParkDialog>);

  readonly parkTypeLabels: Record<ParkType, string> = {
    [ParkType.AMUSEMENTPARK]: 'parks.form.add.parkType.options.AMUSEMENTPARK',
    [ParkType.WATERPARK]: 'parks.form.add.parkType.options.WATERPARK',
    [ParkType.THEMEPARK]: 'parks.form.add.parkType.options.THEMEPARK',
    [ParkType.ANIMALPARK]: 'parks.form.add.parkType.options.ANIMALPARK'
  };

  readonly parkStatusLabels: Record<ParkStatus, string> = {
    [ParkStatus.DEFUNCT]: 'parks.form.add.parkStatus.options.DEFUNCT',
    [ParkStatus.OUT_OF_OPERATION]: 'parks.form.add.parkStatus.options.OUT_OF_OPERATION',
    [ParkStatus.UNDER_CONSTRUCTION]: 'parks.form.add.parkStatus.options.UNDER_CONSTRUCTION',
    [ParkStatus.OPERATING]: 'parks.form.add.parkStatus.options.OPERATING'
  }
  parkTypes = Object.values(ParkType)
  parkStatuses = Object.values(ParkStatus)

  newParkForm = new FormGroup({
    name: new FormControl<string>('', {nonNullable: true}),
    description: new FormControl<string>('',{nonNullable:false}),
    parkType: new FormControl<ParkType>(ParkType.AMUSEMENTPARK),
    openingDate: new FormControl<DateTime | null>(DateTime.now()),
    closingDate: new FormControl<DateTime | null>(DateTime.now()),
    parkStatus: new FormControl<ParkStatus>(ParkStatus.OPERATING),
    address: new FormControl<string>(''),
    areaSize:new FormControl<number>(0)
  })

  storePark() {
    if(this.newParkForm.valid) {
      this.dialogRef.close(this.newParkForm.getRawValue())
    }
  }
}
