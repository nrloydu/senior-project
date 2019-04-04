import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../_services';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { first } from 'rxjs/operators';


@Component({
  templateUrl: './new-poll.component.html',
  styleUrls: ['./new-poll.component.css']
})
export class NewPollComponent implements OnInit {
  pollForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;

  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
    this.pollForm = this.formBuilder.group ({
        title: ['', [Validators.required, Validators.minLength(5)]],
        options: this.formBuilder.array([
          this.initOption(),
        ])
    });
  }

  initOption() {
    //initialize first option
    return this.formBuilder.group({
      choice: ['', Validators.required],
    });
  }

  addOption() {
    // add option to the list
    const control = <FormArray>this.pollForm.controls['options'];
    control.push(this.initOption());
  }

  removeOption(i: number){
    //remove option from the list
    const control = <FormArray>this.pollForm.controls['options'];
    control.removeAt(i);
  }

  

}
