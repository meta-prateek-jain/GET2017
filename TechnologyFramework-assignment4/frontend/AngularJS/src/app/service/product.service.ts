import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Product } from '../product/product';

@Injectable()
export class ProductService {

  private headers = new Headers({ 'Content-Type': 'application/json' });
  private productsUrl = 'http://localhost:8080/shoppingcart/service/product';  // URL to web api
  constructor(private http: Http) { }

  getProducts(): Promise<Product[]> {
    const url = `${this.productsUrl}/list`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Product[])
      .catch(this.handleError);
  }


  getProduct(id: number): Promise<Product> {
    const url = `${this.productsUrl}/get/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Product)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.productsUrl}/delete/${id}`;
    return this.http.delete(url, { headers: this.headers })
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  create(name: string, price: number): Promise<Product> {
    const url = `${this.productsUrl}/add`;
    return this.http
      .post(url, JSON.stringify({name: name , price: price}), {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Product)
      .catch(this.handleError);
  }

  update(product: Product): Promise<Product> {
    const url = `${this.productsUrl}/edit/${product.id}`;
    return this.http
      .put(url, JSON.stringify(product), { headers: this.headers })
      .toPromise()
      .then(() => product)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}

