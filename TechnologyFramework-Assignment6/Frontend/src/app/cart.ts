import { Component, OnInit } from '@angular/core';
import { CartService } from './cart-service';
import { Product } from './product';
import {CartItem } from './cart-item';

@Component({
  selector: 'cart',
  templateUrl: './cart.html'
})

export class Cart implements OnInit {

  cartItem: CartItem[];
  constructor(private cartServices: CartService) { }

  ngOnInit() {
    this.getCartProduct();
  }

  getCartProduct(): void {
    this.cartServices.getCartProducts().then(cartItem => this.cartItem = cartItem);
  }

  checkout(): void{
    
      
      this.cartServices
          .delete(localStorage.getItem("username"))
          .then(() => null 
          );
        }

  deleteFromCart(cart : CartItem){
    for(let i = 0; i < this.cartItem.length; i++){
      if(this.cartItem[i] == cart) {
        this.cartItem.splice(i , 1);
      }
    }
  }
}