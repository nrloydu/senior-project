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

  constructor(
      private formBuilder: FormBuilder,
  ) { }

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
    (this.pollForm.controls['options'] as FormArray).push(this.initOption())
  }

  removeOption(){

  }

  send() {
    console.log(this.pollForm.value);
  }

  

}
