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
var router_1 = require("@angular/router");
var product_service_1 = require("./product.service");
var cart_service_1 = require("./cart-service");
var login_service_service_1 = require("./login-service.service");
var ProductsComponent = (function () {
    function ProductsComponent(productService, router, cartService, login) {
        this.productService = productService;
        this.router = router;
        this.cartService = cartService;
        this.login = login;
    }
    ProductsComponent.prototype.getProducts = function () {
        var _this = this;
        this.productService.getProducts().then(function (response) {
            _this.products = response;
        });
    };
    ProductsComponent.prototype.delete = function (product) {
        var _this = this;
        if (confirm('Are you sure to delete the product : ' + product.name)) {
            this.productService
                .delete(product.id)
                .then(function () {
                _this.products = _this.products.filter(function (h) { return h !== product; });
                if (_this.selectedProduct === product) {
                    _this.selectedProduct = null;
                }
            });
        }
    };
    ProductsComponent.prototype.ngOnInit = function () {
        this.getProducts();
    };
    ProductsComponent.prototype.onSelect = function (product) {
        this.selectedProduct = product;
    };
    ProductsComponent.prototype.gotoDetail = function (product) {
        console.log(product.id);
        this.router.navigate(['/detail', product.id]);
    };
    ProductsComponent.prototype.gotoAddProduct = function () {
        this.router.navigate(['/addProduct']);
    };
    ProductsComponent.prototype.getProductDetail = function () {
        this.router.navigate(['/getProductDetail', this.selectedProduct.id]);
    };
    ProductsComponent.prototype.addToCart = function (product) {
        console.log(product);
        var cartItem = {
            pname: product.name,
            price: product.price,
            productId: product.id,
            userId: this.login.getUsername(),
            quantity: 1
        };
        console.log(this.login.getUsername() + "in product-component");
        this.cartService.addToCart(cartItem);
    };
    return ProductsComponent;
}());
ProductsComponent = __decorate([
    core_1.Component({
        selector: 'my-products',
        templateUrl: './products.component.html',
        styleUrls: ['./products.component.css']
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService,
        router_1.Router,
        cart_service_1.CartService,
        login_service_service_1.LoginService])
], ProductsComponent);
exports.ProductsComponent = ProductsComponent;
//# sourceMappingURL=products.component.js.map