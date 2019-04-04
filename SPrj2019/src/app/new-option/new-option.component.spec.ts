import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewOptionComponent } from './new-option.component';

describe('NewOptionComponent', () => {
  let component: NewOptionComponent;
  let fixture: ComponentFixture<NewOptionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewOptionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewOptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
