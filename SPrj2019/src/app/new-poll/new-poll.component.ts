import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray } from '@angular/forms';
import { first } from 'rxjs/operators';


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

  constructor(
      private formBuilder: FormBuilder,
  ) { 
    this.opArr = [];
    
  }

  ngOnInit() {
    this.pollForm = this.formBuilder.group ({
      options: this.formBuilder.array(
        [this.initOption()]
      )
    })
  }

  initOption() {
    return this.formBuilder.group({
      choice: ['Edit choice']
    })
  }

  addOption() {
    //if (newOption){
      var opValue = (<HTMLInputElement>document.getElementById("optionBox")).value;
      this.opArr.push(opValue);
      document.getElementById("target-id").innerText = opValue;
   // }
    // Add the new option to FormArray
    //(this.pollForm.controls['options'] as FormArray).push(this.initOption())
  }

  removeOption(){

  }

  addUser() {

  }

  removeUser(){
    
  }
  send() {
    console.log(this.pollForm.value);
  }

  

}
