import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TarjetaItemComponent } from './tarjeta-item.component';

describe('TarjetaItemComponent', () => {
  let component: TarjetaItemComponent;
  let fixture: ComponentFixture<TarjetaItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TarjetaItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TarjetaItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
