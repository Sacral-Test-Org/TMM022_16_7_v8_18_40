import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PART_MASTERComponent } from './components/part-master/part-master.component';

@NgModule({
  declarations: [
    PART_MASTERComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    PART_MASTERComponent
  ]
})
export class HPMSModule { }
