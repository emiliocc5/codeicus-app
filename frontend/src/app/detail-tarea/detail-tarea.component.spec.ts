import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailTareaComponent } from './detail-tarea.component';

describe('DetailTareaComponent', () => {
  let component: DetailTareaComponent;
  let fixture: ComponentFixture<DetailTareaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailTareaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailTareaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
