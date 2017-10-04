import { Component, OnInit } from '@angular/core';

import { Product } from '../product/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'my-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

/**
 * Dashboard Component is used to display the dashboard page showing the top products
 */
export class DashboardComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getProducts()
      .then(products => this.products = products.slice(1, 4));
      console.log(this.products);
  }
}
