"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var CartService = (function () {
    function CartService(http) {
        this.http = http;
        this.cartAddUrl = 'http://localhost:8080/DWeb/rest/product/saveToCart'; // Add product URL
        this.cartUrl = 'http://localhost:8080/DWeb/rest/product/getAllCart'; // Add product URL
        this.cartdeleteUrl = 'http://localhost:8080/DWeb/rest/product/checkout'; // Add product URL
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
    }
    CartService.prototype.getCartProducts = function () {
        this.currentUser = localStorage.getItem("username");
        var url = this.cartUrl + "/" + this.currentUser;
        return this.http.get(url)
            .toPromise()
            .then(function (response) { return response.json(); })
            .catch();
    };
    CartService.prototype.addToCart = function (cartItem) {
        return this.http
            .post(this.cartAddUrl, JSON.stringify(cartItem), { headers: this.headers })
            .toPromise()
            .then(function (res) { return res.json(); })
            .catch();
    };
    CartService.prototype.delete = function (id) {
        var url = this.cartdeleteUrl + "/" + id;
        return this.http.get(url)
            .toPromise()
            .then(function () { return null; })
            .catch();
    };
    return CartService;
}());
CartService.cartItem = [];
CartService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], CartService);
exports.CartService = CartService;
//# sourceMappingURL=cart-service.js.map