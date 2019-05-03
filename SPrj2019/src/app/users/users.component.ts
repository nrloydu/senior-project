import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertService } from '../_services';
import { first } from 'rxjs/operators';

import { User } from '../_models';
import { UserService, AuthenticationService } from '../_services'
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  emailForm: FormGroup;
    submitted = false;
    currentUser: User;
    currentUserSubscription: Subscription;
    users: User[] = [];

    constructor(
        private formBuilder: FormBuilder,
        private authenticationService: AuthenticationService,
        private userService: UserService,
        private alertService: AlertService) {
            this.currentUserSubscription = this.authenticationService.currentUser.subscribe(
                users => {this.currentUser = users;
            });
         }

    ngOnInit() {
        this.emailForm = this.formBuilder.group({
            email: ['', [Validators.required, Validators.email]]
        });
        this.loadAllUsers();
    }

    // convenience getter for easy access to form fields
    get f() { return this.emailForm.controls; }

    onInvite() {
        this.submitted = true;

        // stop here if email is invalid
        if (this.emailForm.invalid) {
            return;
        }
        // SEND THE EMAIL WITH THE SERVER
        this.alertService.success('Email sent!', true);
    }

    private loadAllUsers() {
        this.userService.getAll().pipe(first()).subscribe(users => {
            this.users = users;
        });
    }
}
