import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Product } from './product';
import { ProductService } from './product.service';

@Component({
  selector: 'my-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: [ './add-product.component.css' ]
})

export class AddProductComponent {
    products: Product[];
    selectedProduct: Product;

    constructor(
        private productService: ProductService,
        private router: Router) { }

    add(name: string, price: number): void {
        name = name.trim();
        if (!name) { return; }
        this.productService.create(name, price)
          .then(product => {
            this.products.push(product);
            this.selectedProduct = null;
          });
          alert('Product Successfully Added !!');
      }
}
