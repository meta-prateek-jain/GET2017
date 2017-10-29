import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import {Authentication} from './Authentication'
import 'rxjs/add/operator/toPromise';

import { User } from './user';

@Injectable()
export class LoginService {
     
    private headers = new Headers({ 'Content-Type': 'application/json' });
    private userUrl = 'http://localhost:8080/DWeb/rest/product/getUser';
    constructor(private http: Http) {}

    
    
    getUser(username:string,password:string): Promise<Authentication> {
        const url = `${this.userUrl}/${username}/${password} `;
        return this.http.get(url)
        .toPromise()
        .then(response => response.json() as Authentication)
        .catch();
        }

        saveUser(username: string) {
            localStorage.setItem('username', username);
        }
        
        getUsername(): string {
            return localStorage.getItem('username');
        }
}