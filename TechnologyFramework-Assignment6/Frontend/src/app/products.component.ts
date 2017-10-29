import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from './cart-item';
import { Product } from './product';
import { ProductService } from './product.service';
import { CartService } from './cart-service';
import { LoginService } from './login-service.service';

@Component({
    selector: 'my-products',
    templateUrl: './products.component.html',
    styleUrls: [ './products.component.css' ]
  })

  export class ProductsComponent implements OnInit {
      products: Product[];
      selectedProduct: Product;

      constructor(
        private productService: ProductService,
        private router: Router,
        private cartService:CartService,
        private login: LoginService) { }

      getProducts(): void {
        this.productService.getProducts().then(response => {
          this.products = response;
        });
      }

      delete(product: Product): void {
        if ( confirm ('Are you sure to delete the product : ' + product.name )) {
        this.productService
            .delete(product.id)
            .then(() => {
              this.products = this.products.filter(h => h !== product);
              if (this.selectedProduct === product) { this.selectedProduct = null; }
            });
          }
      }

      ngOnInit(): void {
        this.getProducts();
      }

      onSelect(product: Product): void {
        this.selectedProduct = product;
      }

      gotoDetail(product: Product): void {
        console.log(product.id)
        this.router.navigate(['/detail', product.id]);
      }

      gotoAddProduct(): void {
        this.router.navigate(['/addProduct']);
      }

      getProductDetail(): void {
        this.router.navigate(['/getProductDetail', this.selectedProduct.id]);
      }
      addToCart(product:Product): void{
        console.log(product);
        let cartItem: CartItem = {
          pname: product.name,
          price: product.price,
          productId: product.id,
          userId: this.login.getUsername(),
          quantity:1
        };
        console.log(this.login.getUsername() + "in product-component");
        this.cartService.addToCart(cartItem);

      }
}
