import { Injectable } from '@angular/core';
import { Product } from './Product';
import { CartItem } from './cart-item';
import { Headers, Http } from '@angular/http';

@Injectable()
export class CartService {

    constructor(private http: Http) { }
    private currentUser:String; 
    static cartItem: CartItem[] = [];
    private cartAddUrl = 'http://localhost:8080/DWeb/rest/product/saveToCart'; // Add product URL
    private cartUrl = 'http://localhost:8080/DWeb/rest/product/getAllCart'; // Add product URL
    private cartdeleteUrl = 'http://localhost:8080/DWeb/rest/product/checkout'; // Add product URL
    private headers = new Headers({'Content-Type': 'application/json'});
    getCartProducts(): Promise<CartItem[]> {
        this.currentUser=localStorage.getItem("username");
        const url = `${this.cartUrl}/${this.currentUser}`;
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as CartItem[])
        .catch();
    }

    addToCart(cartItem: CartItem):Promise<CartItem> {
            return this.http
            .post(this.cartAddUrl, JSON.stringify(cartItem), {headers: this.headers})
            .toPromise()
            .then(res => res.json() as CartItem)
            .catch();
            }
     delete(id: string): Promise<void> {
                const url = `${this.cartdeleteUrl}/${id}`;
                return this.http.get(url)
                .toPromise()
                .then(() => null)
                .catch();
                }
            
    
}