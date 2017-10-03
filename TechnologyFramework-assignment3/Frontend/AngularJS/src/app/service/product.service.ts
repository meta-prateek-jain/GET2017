import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Product } from '../product/product';

@Injectable()
export class ProductService {

  private headers = new Headers({ 'Content-Type': 'application/json' });
  private productsUrl = 'http://localhost:8080/shopping-cart/service/product/list';  // URL to web api
  private productAddUrl = 'http://localhost:8080/shopping-cart/service/product/add'; // Add product URL
  private productGetByIdUrl = 'http://localhost:8080/shopping-cart/service/product/get'; //Get product by id
  private productEdit = 'http://localhost:8080/shopping-cart/service/product/edit';
  private productDelete = 'http://localhost:8080/shopping-cart/service/product/delete';
  constructor(private http: Http) { }

  getProducts(): Promise<Product[]> {
    return this.http.get(this.productsUrl)
      .toPromise()
      .then(response => response.json() as Product[])
      .catch(this.handleError);
  }


  getProduct(id: number): Promise<Product> {
    const url = `${this.productGetByIdUrl}/${id}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Product)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.productDelete}/${id}`;
    return this.http.delete(url, { headers: this.headers })
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  create(name: string, price: number): Promise<Product> {
   return this.http
      .post(this.productAddUrl, JSON.stringify({name: name , price: price}), {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Product)
      .catch(this.handleError);
  }

  update(product: Product): Promise<Product> {
    const url = `${this.productEdit}/${product.id}`;
    console.log(url);
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

