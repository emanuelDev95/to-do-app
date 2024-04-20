import { Routes } from '@angular/router';
import { ListComponent } from './list/list.component';
import { FormComponent } from './form/form.component';

export const routes: Routes = [
    {path:'list', component: ListComponent },
    {path:'form', component: FormComponent},
    {path:'form/:id', component: FormComponent},
    { path: '', redirectTo: 'list', pathMatch: "prefix"}
];