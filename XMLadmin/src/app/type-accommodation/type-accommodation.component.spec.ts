import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeAccommodationComponent } from './type-accommodation.component';

describe('TypeAccommodationComponent', () => {
  let component: TypeAccommodationComponent;
  let fixture: ComponentFixture<TypeAccommodationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypeAccommodationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypeAccommodationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
