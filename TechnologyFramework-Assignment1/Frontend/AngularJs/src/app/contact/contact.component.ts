import { Component } from '@angular/core';
import { Location } from '@angular/common';

import { Product } from '../product/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'contact-us',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})

/**
 * Contact component is used to display the contact us page showing contact form
 */
export class ContactComponent {

  constructor(
    private productService: ProductService,
    private location: Location
  ) { }

  goBack(): void {
    this.location.back();
  }
}
