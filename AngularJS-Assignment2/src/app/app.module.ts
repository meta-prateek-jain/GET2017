import { ContactComponent } from './contact/contact.component';
import { EditProductComponent } from './product/edit-product.component';
import { AddProductComponent } from './product/add-product.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';

// Imports for loading & configuring the in-memory web api
import { InMemoryWebApiModule } from 'angular-in-memory-web-api/in-memory-web-api.module';
import { InMemoryDataService } from './service/in-memory-data.service';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProductsComponent } from './product/products.component';
import { ProductDetailComponent } from './product/product-detail.component';
import { ProductService } from './service/product.service';
import { ProductSearchComponent } from './product/product-search.component';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService),
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    AddProductComponent,
    DashboardComponent,
    EditProductComponent,
    ProductDetailComponent,
    ProductsComponent,
    ProductSearchComponent,
    ContactComponent
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
