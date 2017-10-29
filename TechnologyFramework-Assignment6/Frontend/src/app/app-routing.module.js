"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var router_1 = require("@angular/router");
var dashboard_component_1 = require("./dashboard.component");
var products_component_1 = require("./products.component");
var product_detail_component_1 = require("./product-detail.component");
var contact_us_component_1 = require("./contact-us.component");
var add_product_component_1 = require("./add-product.component");
var get_product_detail_component_1 = require("./get-product-detail.component");
var Cart_1 = require("./Cart");
var checkout_1 = require("./checkout");
var login_component_1 = require("./login-component");
var payment_component_1 = require("./payment.component");
var routes = [
    { path: '', component: login_component_1.LoginComponent },
    { path: 'dashboard', component: dashboard_component_1.DashboardComponent },
    { path: 'detail/:id', component: product_detail_component_1.ProductDetailComponent },
    { path: 'productsList', component: products_component_1.ProductsComponent },
    { path: 'contactUs', component: contact_us_component_1.ContactUsComponent },
    { path: 'addProduct', component: add_product_component_1.AddProductComponent },
    { path: 'getProductDetail/:id', component: get_product_detail_component_1.GetProductDetailComponent },
    { path: 'cart', component: Cart_1.Cart },
    { path: 'checkout', component: checkout_1.Checkout },
    { path: 'payment', component: payment_component_1.PaymentComponent }
];
var AppRoutingModule = (function () {
    function AppRoutingModule() {
    }
    return AppRoutingModule;
}());
AppRoutingModule = __decorate([
    core_1.NgModule({
        imports: [router_1.RouterModule.forRoot(routes)],
        exports: [router_1.RouterModule]
    })
], AppRoutingModule);
exports.AppRoutingModule = AppRoutingModule;
//# sourceMappingURL=app-routing.module.js.map