"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var platform_browser_1 = require("@angular/platform-browser");
var core_1 = require("@angular/core");
var forms_1 = require("@angular/forms");
var http_1 = require("@angular/http");
var Cart_1 = require("./Cart");
var app_routing_module_1 = require("./app-routing.module");
// Imports for loading & configuring the in-memory web api
var app_component_1 = require("./app.component");
var login_component_1 = require("./login-component");
var dashboard_component_1 = require("./dashboard.component");
var products_component_1 = require("./products.component");
var product_detail_component_1 = require("./product-detail.component");
var product_service_1 = require("./product.service");
var product_search_component_1 = require("./product-search.component");
var contact_us_component_1 = require("./contact-us.component");
var add_product_component_1 = require("./add-product.component");
var get_product_detail_component_1 = require("./get-product-detail.component");
var cart_service_1 = require("./cart-service");
var login_service_service_1 = require("./login-service.service");
var checkout_1 = require("./checkout");
var payment_component_1 = require("./payment.component");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [
            platform_browser_1.BrowserModule,
            forms_1.FormsModule,
            http_1.HttpModule,
            app_routing_module_1.AppRoutingModule
        ],
        declarations: [
            app_component_1.AppComponent,
            dashboard_component_1.DashboardComponent,
            product_detail_component_1.ProductDetailComponent,
            products_component_1.ProductsComponent,
            product_search_component_1.ProductSearchComponent,
            contact_us_component_1.ContactUsComponent,
            Cart_1.Cart,
            add_product_component_1.AddProductComponent,
            get_product_detail_component_1.GetProductDetailComponent,
            login_component_1.LoginComponent,
            checkout_1.Checkout,
            payment_component_1.PaymentComponent
        ],
        providers: [product_service_1.ProductService, cart_service_1.CartService, login_service_service_1.LoginService],
        bootstrap: [app_component_1.AppComponent]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map