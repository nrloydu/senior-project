import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-new-option',
  templateUrl: './new-option.component.html',
  styleUrls: ['./new-option.component.css']
})
export class NewOptionComponent {

  @Input('group')
  public optionForm: FormGroup;

}
