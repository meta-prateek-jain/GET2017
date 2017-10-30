import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Product } from '../product/product';

@Injectable()
export class ProductSearchService {

  constructor(private http: Http) { }

  search(term: string): Observable<Product[]> {
    console.log(term);
    return this.http
      .get(`http://localhost:8080/shoppingcart/service/product/get/?name=${term}`)
      .map(response => response.json() as Product[]);
  }
}
