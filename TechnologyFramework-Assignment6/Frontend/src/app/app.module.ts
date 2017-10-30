import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Cart } from './Cart'
import { AppRoutingModule } from './app-routing.module';
// Imports for loading & configuring the in-memory web api

import { AppComponent } from './app.component';
import {LoginComponent} from './login-component';
import { DashboardComponent } from './dashboard.component';
import { ProductsComponent } from './products.component';
import { ProductDetailComponent } from './product-detail.component';
import { ProductService } from './product.service';
import { ProductSearchComponent } from './product-search.component';
import { ContactUsComponent } from './contact-us.component';
import { AddProductComponent } from './add-product.component';
import { GetProductDetailComponent } from './get-product-detail.component';
import { CartService } from './cart-service';
import { LoginService} from './login-service.service';
import { Checkout } from './checkout';
import { PaymentComponent } from './payment.component';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    DashboardComponent,
    ProductDetailComponent,
    ProductsComponent,
    ProductSearchComponent,
    ContactUsComponent,
    Cart,
    AddProductComponent,
    GetProductDetailComponent,
    LoginComponent,
    Checkout,
    PaymentComponent
    
  ],
  providers: [ ProductService, CartService,LoginService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
