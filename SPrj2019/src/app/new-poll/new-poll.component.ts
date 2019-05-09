import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

import { User } from '../_models';
import { AlertService, UserService, AuthenticationService, PollService } from '../_services'
import { Subscription } from 'rxjs';
import { ExitStatus } from 'typescript';
//import { SSL_OP_SSLEAY_080_CLIENT_DH_BUG } from 'constants';


@Component({
  templateUrl: './new-poll.component.html'
})
export class NewPollComponent implements OnInit {
  pollForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  choice: 'Angular 7';
  // Change this array type to new poll component
  opArr: Array<string>;
  options: FormArray;
  currentUser: User;
  currentUserSubscription: Subscription;
  users: User[] = [];
  pollUsers: User[] = [];

  constructor(private formBuilder: FormBuilder,
              private userService: UserService,
              private authenticationService: AuthenticationService,
              private alertService: AlertService,
              private pollService: PollService,
              private router: Router ) {
                this.currentUserSubscription = this.authenticationService.currentUser.subscribe(
                  users => {this.currentUser = users;
              });
              }

  ngOnInit() {
    this.pollForm = this.formBuilder.group ({
      pollTitle: ['', Validators.required],
      options: this.formBuilder.array(
        [this.initOption()]
      ),
      sendUser: ['', Validators.required]
    });
    this.loadAllUsers();
  }

  onSubmit() {

    this.submitted = true;

    if(this.pollForm.invalid) {
      return;
    }

    this.pollService.create(this.pollForm.value).pipe(first())
      .subscribe(
        data => {
          this.alertService.success("Form submitted", true);
          this.router.navigate(['/']);
        },
        error => {
          console.log("Cannot submit");
          this.alertService.error(error);
        }
      );
    console.log("Submitted!!!!")


  }

  initOption() {
    return this.formBuilder.group({
      label: ''
    });
  }

  addOption(): void {
    //if (newOption){
      /*var opValue = (<HTMLInputElement>document.getElementById("optionBox")).value;
      this.opArr.push(opValue);
      document.getElementById("target-id").innerText = opValue;*/
   // }
    // Add the new option to FormArray
    //(this.pollForm.controls['options'] as FormArray).push(this.initOption())

    this.options = this.pollForm.get('options') as FormArray;
    this.options.push(this.initOption());
  }

  removeOption(){
    this.options = this.pollForm.get('options') as FormArray;
    this.options.removeAt(this.options.length - 1);
  }

  addUser(id: number) {
    //arrLen: Number = this.users.push(this.userService.getById(id));
  }

  removeUser(){

  }
  send() {
    console.log(this.pollForm.value);
  }

  findUser(name: string){
    var i:number;
    console.log("I'm in findUser");
    console.log(this.users.length);
    for(i = 0, i; this.users.length; i++){
      console.log("Value of first value: " + this.users[i].firstName);
      console.log("Value of passed in value: " + name);
      if(this.users[i].firstName == name)
      {
        //this.pollUsers.push(this.users[i]); 
        this.pollForm.controls['sendUser'].setValue(name);
        this.alertService.success("User added.", true);
        console.log(this.users[i]);
        break;
      }
      else {
        console.log("User not found");
      }
    }

  }

  private loadAllUsers() {
    this.userService.getAll().pipe(first()).subscribe(allUsers => {
        this.users = allUsers;
    });
  }
}
