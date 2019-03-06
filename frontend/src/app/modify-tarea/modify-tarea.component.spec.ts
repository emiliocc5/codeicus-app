import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyTareaComponent } from './modify-tarea.component';

describe('ModifyTareaComponent', () => {
  let component: ModifyTareaComponent;
  let fixture: ComponentFixture<ModifyTareaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyTareaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyTareaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
