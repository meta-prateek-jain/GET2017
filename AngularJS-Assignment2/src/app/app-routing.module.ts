import { ContactComponent } from './contact/contact.component';
import { EditProductComponent } from './product/edit-product.component';
import { AddProductComponent } from './product/add-product.component';
import { ProductsComponent } from './product/products.component';
import { ProductDetailComponent } from './product/product-detail.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard',  component: DashboardComponent },
  { path: 'products/:id', component: EditProductComponent },
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'products',   component: ProductsComponent },
  { path: 'contactus',   component: ContactComponent },
  { path: 'addproduct', component: AddProductComponent},
  { path: '**', component: DashboardComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
