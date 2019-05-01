import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersComponent } from '../users/users.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [UsersComponent],
  exports: [
    UsersComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class UsersModule { }
