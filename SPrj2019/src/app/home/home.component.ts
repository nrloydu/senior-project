import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { first } from 'rxjs/operators';

import { User, Poll } from '../_models';
import { UserService, AuthenticationService, PollService } from '../_services';
import { FormBuilder, FormGroup, FormArray, FormControl, ValidatorFn } from '@angular/forms';


@Component({ templateUrl: 'home.component.html' })
export class HomeComponent implements OnInit, OnDestroy {
    currentUser: User;
    currentUserSubscription: Subscription;
    users: User[] = [];
    poll: Poll[] = [];
    form: FormGroup;
    optionArr = [
        { id: 1, name: 'option 1' },
        { id: 2, name: 'option 2' },
        { id: 3, name: 'option 3' },
    ];

    constructor(
        private authenticationService: AuthenticationService,
        private userService: UserService,
        private pollService: PollService,
        private formBuilder: FormBuilder,
    ) {
        this.currentUserSubscription = this.authenticationService.currentUser.subscribe(user => {
            this.currentUser = user;
        });
        this.form = this.formBuilder.group({
            optionArr: new FormArray([], minSelectedCheckboxes(1))
        });

        this.addCheckboxes();
    }

    private addCheckboxes() {
        this.optionArr.map((o, i) => {
            const control = new FormControl(i === 0); // if first item set to true, else false
            (this.form.controls.optionArr as FormArray).push(control);
        });
    }

    submit() {
        console.log(this.form.value);
    }

    ngOnInit() {
        this.loadAllUsers();
        this.loadAllPolls();
        this.displayActivePolls();
    }

    displayActivePolls() {
        //for loop checks the user field of a poll
        
    }

    ngOnDestroy() {
        // unsubscribe to ensure no memory leaks
        this.currentUserSubscription.unsubscribe();
    }

    deleteUser(id: number) {
        this.userService.delete(id).pipe(first()).subscribe(() => {
            this.loadAllUsers();
        });
    }

    private loadAllUsers() {
        this.userService.getAll().pipe(first()).subscribe(users => {
            this.users = users;
        });
    }

    private loadAllPolls() {
        this.pollService.getAll().pipe(first()).subscribe(poll => {
            this.poll = poll;
        })
        // Check user field if current user load poll
        //if (this.currentUser.firstName = poll.user.firstName){
        // }
    }
}
function minSelectedCheckboxes(min = 1) {
    const validator: ValidatorFn = (formArray: FormArray) => {
        const totalSelected = formArray.controls
            // get a list of checkbox values (boolean)
            .map(control => control.value)
            // total up the number of checked checkboxes
            .reduce((prev, next) => next ? prev + next : prev, 0);

        // if the total is not greater than the minimum, return the error message
        return totalSelected >= min ? null : { required: true };
    };

    return validator;
}