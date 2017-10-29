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
var AddProductComponent = (function () {
    function AddProductComponent(productService, router) {
        this.productService = productService;
        this.router = router;
    }
    AddProductComponent.prototype.add = function (name, price) {
        var _this = this;
        name = name.trim();
        if (!name) {
            return;
        }
        this.productService.create(name, price)
            .then(function (product) {
            _this.products.push(product);
            _this.selectedProduct = null;
        });
        alert('Product Successfully Added !!');
    };
    return AddProductComponent;
}());
AddProductComponent = __decorate([
    core_1.Component({
        selector: 'my-add-product',
        templateUrl: './add-product.component.html',
        styleUrls: ['./add-product.component.css']
    }),
    __metadata("design:paramtypes", [product_service_1.ProductService,
        router_1.Router])
], AddProductComponent);
exports.AddProductComponent = AddProductComponent;
//# sourceMappingURL=add-product.component.js.map