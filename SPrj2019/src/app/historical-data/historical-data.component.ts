import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, ValidatorFn } from '@angular/forms';
import { AlertService } from '../_services';

@Component({
  selector: 'app-historical-data',
  templateUrl: './historical-data.component.html',
  styleUrls: ['./historical-data.component.css']
})
export class HistoricalDataComponent implements OnInit {
  form: FormGroup;
  optionArr = [
    { id: 1, name: 'option 1' },
    { id: 2, name: 'option 2' },
    { id: 3, name: 'option 3' },
  ];

  constructor(private formBuilder: FormBuilder,
    private alertService: AlertService) {
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
     // Assuming options are array optionList
  //JSON.stringify(this.optionList);
  //localStorage.setItem("opList", JSON.stringify(this.optionList));
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