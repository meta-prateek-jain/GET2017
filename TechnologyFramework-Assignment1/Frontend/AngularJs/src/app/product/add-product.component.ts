import 'rxjs/add/operator/switchMap';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import { Product } from '../product/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})

/**
 * AddProductComponent is used to display template to add the product to product list
 */
export class AddProductComponent implements OnInit {
  products: Product[];
  error_message: string;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  /**
   * Method is used to get the products list
   */
  getProducts(): void {
    this.productService
      .getProducts()
      .then(products => this.products = products);
  }

  /**
   * Method is used to add the product to list 
   * @param name
   *        name of the product
   * @param price 
   *        price of the product
   */
  add(name: string, price: number): void {
    name = name.trim();
    // if name and price are not entered then return to page after displaying an alert message
    if (!name || !price) {
      alert('Please fill all the fields');
      return;
    }
    this.productService.create(name, price)
      .then(product => {
        this.products.push(product);
        this.goBack();
      });
  }

  /**
   * Method is used to go back to previous page
   */
  goBack(): void {
    this.location.back();
  }

  ngOnInit(): void {
    this.getProducts();
  }
}
