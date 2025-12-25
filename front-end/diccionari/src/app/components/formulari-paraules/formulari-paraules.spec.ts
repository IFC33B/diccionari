import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulariParaules } from './formulari-paraules';

describe('FormulariParaules', () => {
  let component: FormulariParaules;
  let fixture: ComponentFixture<FormulariParaules>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormulariParaules]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormulariParaules);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
