import { Component } from '@angular/core';
import { Router, Routes } from '@angular/router';
import { Validators, FormGroup, FormArray, FormBuilder } from '@angular/forms';


import { AuthenticationService } from './_services';
import { User } from './_models';
import { NewPollComponent } from './new-poll/new-poll.component';
import { HistoricalDataComponent } from './historical-data/historical-data.component';

@Component({ selector: 'app', templateUrl: 'app.component.html' })
export class AppComponent {
    currentUser: User;

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) {
        this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
    }

    logout() {
        this.authenticationService.logout();
        this.router.navigate(['/login']);
    }

}

