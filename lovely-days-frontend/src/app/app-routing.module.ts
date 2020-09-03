import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DashboardComponent} from './dashboard/dashboard.component';
import {DayTableComponent} from './day/component/day-table/day-table.component';

const routes: Routes = [
  {
    path: '',
    // component: DashboardComponent
    component: DayTableComponent
  },
  {
    path: 'days',
    component: DayTableComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
