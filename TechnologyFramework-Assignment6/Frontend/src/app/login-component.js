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
var login_service_service_1 = require("./login-service.service");
var router_1 = require("@angular/router");
var app_component_1 = require("./app.component");
var LoginComponent = (function () {
    function LoginComponent(log, router, appcomponent) {
        this.log = log;
        this.router = router;
        this.appcomponent = appcomponent;
    }
    LoginComponent.prototype.ngOnInit = function () {
        this.prompt;
    };
    LoginComponent.prototype.login = function (username, password) {
        var _this = this;
        this.log.getUser(username, password).then(function (response) {
            _this.authenticationObject = response;
            if (_this.authenticationObject.authenticationFlag) {
                _this.log.saveUser(username);
                console.log(_this.log.getUsername() + "in compo");
                _this.appcomponent.show();
                _this.router.navigate(['/dashboard']);
            }
            else {
                _this.prompt = true;
                _this.router.navigate(['/']);
            }
        });
    };
    return LoginComponent;
}());
LoginComponent = __decorate([
    core_1.Component({
        selector: 'my-login',
        templateUrl: './login.html',
        styleUrls: ['./login-style.css']
    }),
    __metadata("design:paramtypes", [login_service_service_1.LoginService, router_1.Router, app_component_1.AppComponent])
], LoginComponent);
exports.LoginComponent = LoginComponent;
//# sourceMappingURL=login-component.js.map