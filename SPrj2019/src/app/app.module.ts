import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {RouterModule, Routes} from "@angular/router";
//import {ChartsModule} from 'ng2-Charts';

import { fakeBackendProvider } from './_helpers';
import { AppService } from './app.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { AlertComponent } from './_components/alert.component';
import { HomeComponent } from './home/home.component';

import { JwtInterceptor, ErrorInterceptor } from './_helpers';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import { ApiService } from './_services/api.service';
import { NewPollComponent } from './new-poll/new-poll.component';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { NewOptionComponent } from './new-option/new-option.component';
import { HistoricalDataComponent } from './historical-data/historical-data.component';
import { UsersComponent } from './users/users.component';


const routeConfig: Routes = [
    { path: 'new-poll', component: NewPollComponent, data: {title: 'Create a New Poll'}},
    { path: 'historical-data', component: HistoricalDataComponent, data: {title: 'View Historical Poll Data'}},
    { path: 'users', component: UsersComponent, data: {title: 'Manage Users'}}
];
@NgModule({
  imports: [
      BrowserModule,
      RouterModule.forRoot(routeConfig),
      ReactiveFormsModule,
      //ChartsModule,
      HttpClientModule,
      routing
  ],
  declarations: [
      AppComponent,
      AlertComponent,
      HomeComponent,
      LoginComponent,
      RegisterComponent,
      NewPollComponent,
      NewOptionComponent,
      HistoricalDataComponent,
      UsersComponent,
  ],
  providers: [
      { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
      { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
      AppService,

      // provider used to create fake backend
      fakeBackendProvider,
      ApiService
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }

platformBrowserDynamic().bootstrapModule(AppModule);
