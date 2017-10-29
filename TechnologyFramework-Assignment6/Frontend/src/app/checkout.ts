import { Component, OnInit } from '@angular/core';
import { AppComponent } from './app.component';

@Component({
  selector: 'my-checkout',
  templateUrl: './checkout.html',
  styleUrls: ['./checkout.css']
})
export class Checkout{
  title = 'ShoppingCart app';

  constructor(private appcomponent : AppComponent ){ }
  
    login(){

      this.appcomponent.hide();

    }
}
