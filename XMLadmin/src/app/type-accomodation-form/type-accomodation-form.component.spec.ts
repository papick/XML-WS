import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeAccomodationFormComponent } from './type-accomodation-form.component';

describe('TypeAccomodationFormComponent', () => {
  let component: TypeAccomodationFormComponent;
  let fixture: ComponentFixture<TypeAccomodationFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypeAccomodationFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypeAccomodationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
