// import 'rxjs/add/operator/switchMap';
// import { Component, OnInit }        from '@angular/core';
// import { ActivatedRoute, ParamMap } from '@angular/router';
// import { Location }                 from '@angular/common';

// import { Product }        from '../product/product';
// import { ProductService } from '../service/product.service';

// @Component({
//   selector: 'delete-product',
//   templateUrl: './delete-product.component.html',
// })
// export class DeleteProductComponent implements OnInit {
//   products: Product[];
  
//   constructor(
//     private productService: ProductService,
//     private route: ActivatedRoute,
//     private location: Location
//   ) {}


//   getProducts(): void {
//     this.productService
//         .getProducts()
//         .then(products => this.products = products);
//   }

//   delete(product: Product): void {
//     this.productService
//         .delete(product.id)
//         .then(() => {
//           this.products = this.products.filter(element => element !== product);
        
//         });
//   }

//   goBack(): void {
//     this.location.back();
//   }

  
//   ngOnInit(): void {
//     this.getProducts();
//   }
// }



import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { ProductService } from '../service/product.service';
import {Location} from '@angular/common';
import 'rxjs/add/operator/switchMap';
@Component
({
selector: 'delete-product',
templateUrl: './delete-product.component.html'
})
export class DeleteProductComponent implements OnInit {
products: Product[];
product: Product;
constructor(
private productService: ProductService,
private router: ActivatedRoute,
private location : Location
) { }

ngOnInit(): void {
this.productService.getProducts().then(products => this.products = products);
this.router.paramMap
.switchMap((params: ParamMap) => this.productService
.getProduct(+params.get('id')))
.subscribe(product => this.product = product);
}

deleteProduct(): void {
this.productService
.delete(this.product.id)
.then(() => {
this.products = this.products.filter(p => p !== this.product);
});
this.goBack();
}
goBack():void{
this.location.back();
}

}