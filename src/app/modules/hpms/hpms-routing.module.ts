import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PartMasterComponent } from './components/part-master/part-master.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'part-master',
        component: PartMasterComponent
      },
      {
        path: '',
        redirectTo: 'part-master',
        pathMatch: 'full'
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HPMSRoutingModule { }
