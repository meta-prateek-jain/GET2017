import { Injectable } from '@angular/core';
import { Product } from './product';
import { Products } from './mock-products';

@Injectable ()
export class ProductService {
    getProducts(): Promise<Product[]> {
        return Promise.resolve(Products);
    }
}
