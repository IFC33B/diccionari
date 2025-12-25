import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LlistaParaules } from './llista-paraules';

describe('LlistaParaules', () => {
  let component: LlistaParaules;
  let fixture: ComponentFixture<LlistaParaules>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LlistaParaules]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LlistaParaules);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
