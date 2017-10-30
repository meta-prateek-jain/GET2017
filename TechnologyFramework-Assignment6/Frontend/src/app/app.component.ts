import { Component, OnInit } from '@angular/core';
import {LoginService} from './login-service.service'

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'ShoppingCart app';
  visible:boolean;
  constructor(){}

  ngOnInit() {
    this.hide();
  }

  hide(){
    this.visible = false;
  }

  show() {
    this.visible = true;
  }
  signout():void{
    localStorage.removeItem("username");
    this.visible=false;
  }
  
  
  
  
  
  
  
}
