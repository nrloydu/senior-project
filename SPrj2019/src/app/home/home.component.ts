import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { first } from 'rxjs/operators';

import { User, Poll, Option } from '../_models';
import { UserService, AuthenticationService, PollService } from '../_services';
import { FormBuilder, FormGroup, FormArray, FormControl, ValidatorFn } from '@angular/forms';


@Component({ templateUrl: 'home.component.html' })
export class HomeComponent implements OnInit, OnDestroy {
    currentUser: User;
    currentUserSubscription: Subscription;
    users: User[] = [];
    poll: Poll[] = [];
    form: FormGroup;
    optionArr: Option[];
    displayPoll: Boolean = false;
    currentPoll: Poll;

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
        console.log("BEFORE LOADAUSER ONINIT->>>> poll 0 is: " );
        console.log("INSIDE ONINIT->>>> users 0 is: " + this.users.length);

        this.loadAllUsers();
        console.log("AFTER USER->>>> poll 0 is: " );

        this.loadAllPolls();
        console.log("outside of pollservicegwheghtjy")

        console.log("INSIDE ONINIT->>>> poll 0 is: " + this.poll[1].pollTitle);
        console.log("outside of pollservicegwheghtjy")

        this.displayActivePolls();
    }

    displayActivePolls() {
        var i:number;

        for(i = 0; i < this.poll.length; i++){
            if(this.poll[i].users == this.currentUser.firstName) {
                this.displayPoll = true;
                this.currentPoll = this.poll[i];
                this.optionArr = this.currentPoll.option;
            }
        }
        this.addCheckboxes();
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
            console.log("INSIDE LOADALLPOLLS ->>>" + this.poll[3].pollTitle +this.poll.length);
        });
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