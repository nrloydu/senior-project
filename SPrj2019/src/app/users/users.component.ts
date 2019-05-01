import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertService } from '../_services';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  emailForm: FormGroup;
    submitted = false;

    constructor(private formBuilder: FormBuilder,
        private alertService: AlertService) { }

    ngOnInit() {
        this.emailForm = this.formBuilder.group({
            email: ['', [Validators.required, Validators.email]]
        });
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
}
