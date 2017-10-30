import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard.component';
import { ProductsComponent } from './products.component';
import { ProductDetailComponent } from './product-detail.component';
import { ContactUsComponent } from './contact-us.component';
import { AddProductComponent } from './add-product.component';
import { GetProductDetailComponent } from './get-product-detail.component';
import { Cart } from './Cart';
import { Checkout } from './checkout';
import { LoginComponent } from './login-component';
import { PaymentComponent } from './payment.component';

const routes: Routes = [
  { path: '', component:LoginComponent},
  { path: 'dashboard',  component: DashboardComponent },
  { path: 'detail/:id', component: ProductDetailComponent },
  { path: 'productsList', component: ProductsComponent },
  { path: 'contactUs', component: ContactUsComponent },
  { path: 'addProduct', component: AddProductComponent },
  { path: 'getProductDetail/:id', component: GetProductDetailComponent },
  { path: 'cart', component: Cart },
  { path: 'checkout', component: Checkout },
  { path: 'payment', component: PaymentComponent }

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
