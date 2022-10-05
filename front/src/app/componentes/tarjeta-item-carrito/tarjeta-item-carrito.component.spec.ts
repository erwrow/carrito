import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TarjetaItemCarritoComponent } from './tarjeta-item-carrito.component';

describe('TarjetaItemCarritoComponent', () => {
  let component: TarjetaItemCarritoComponent;
  let fixture: ComponentFixture<TarjetaItemCarritoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TarjetaItemCarritoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TarjetaItemCarritoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
