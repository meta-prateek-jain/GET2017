import { Injectable } from '@angular/core';

import { Product } from './product';
import { PRODUCTS } from './product-mock';

@Injectable()
export class ProductService {
    getProducts(): Product[] {
        return PRODUCTS;
    }
}