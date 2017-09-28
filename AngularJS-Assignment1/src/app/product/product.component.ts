import { Component, OnInit } from '@angular/core';

import { Product } from './product';
import { PRODUCTS } from './product-mock';
import { ProductService } from './product.service';

@Component ({
    selector: 'app-product',
    templateUrl: './product.component.html'
})
export class ProductComponent implements OnInit{
    title: string = 'Products List';
    products: Product[];

    constructor(private productService: ProductService) { }

    ngOnInit(): void {
        this.getProducts();
    }
    
    getProducts(): void {
        this.products = this.productService.getProducts();
    }
}