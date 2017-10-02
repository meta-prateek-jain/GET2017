import 'rxjs/add/operator/switchMap';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import { Product } from '../product/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})

/**
 * Edit product class is ued to display the template to edit product
 */
export class EditProductComponent implements OnInit {
  product: Product;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.route.paramMap
      .switchMap((params: ParamMap) => this.productService.getProduct(+params.get('id')))
      .subscribe(product => this.product = product);
  }

  /**
   * Method is used to save the updated product
   */
  save(): void {
    this.productService.update(this.product)
      .then(() => this.goBack());
  }

  /**
   * Method is used to go back to previous page
   */
  goBack(): void {
    this.location.back();
  }
}
