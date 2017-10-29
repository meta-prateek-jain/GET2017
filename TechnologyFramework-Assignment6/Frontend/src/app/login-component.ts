import { User } from './user';
import { Component, OnInit } from '@angular/core';
import {LoginService} from './login-service.service';
import { Authentication } from './Authentication';
import { Router } from '@angular/router';
import { AppComponent } from './app.component';

@Component({
    selector: 'my-login',
    templateUrl: './login.html',
    styleUrls: [ './login-style.css' ]
  })


  export class LoginComponent implements OnInit {
    authenticationObject:Authentication;
    prompt:boolean;
    constructor(private log:LoginService,private router:Router, private appcomponent : AppComponent ){ }
    ngOnInit(): void {
       this.prompt;
      }
      login(username:string,password:string){

        

        this.log.getUser(username,password).then(response => {
          
          this.authenticationObject = response;
          if(this.authenticationObject.authenticationFlag) {
                this.log.saveUser(username);
                console.log(this.log.getUsername() + "in compo");
                this.appcomponent.show();
              this.router.navigate(['/dashboard']);
            }else {
              this.prompt=true;
              this.router.navigate(['/']);
            }
        });
      }
    }