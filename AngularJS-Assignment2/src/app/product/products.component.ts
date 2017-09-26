import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Product } from './product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'my-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products: Product[];
  selectedProduct: Product;

  constructor(
    private productService: ProductService,
    private router: Router) { }

    /**
     * Method is used to get the products list
     */
  getProducts(): void {
    this.productService
      .getProducts()
      .then(products => this.products = products);
  }

  /**
   * 
   * @param product Method is used to delete the particular selected product
   */
  delete(product: Product): void {
    this.productService
      .delete(product.id)
      .then(() => {
        this.products = this.products.filter(element => element !== product);
        if (this.selectedProduct === product) { this.selectedProduct = null; }
      });
  }

  ngOnInit(): void {
    this.getProducts();
  }

  /**
   * Method is used to add product
   */
  addProduct(): void {
    this.router.navigate(['/addproduct'])
  }
}
