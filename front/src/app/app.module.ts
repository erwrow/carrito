import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TarjetaItemComponent } from './componentes/tarjeta-item/tarjeta-item.component';
import { TarjetaItemCarritoComponent } from './componentes/tarjeta-item-carrito/tarjeta-item-carrito.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    TarjetaItemComponent,
    TarjetaItemCarritoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
