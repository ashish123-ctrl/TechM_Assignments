var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Car = /** @class */ (function () {
    function Car(make, model, year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    Car.prototype.displayInfo = function () {
        console.log("Car: ".concat(this.year, " ").concat(this.make, " ").concat(this.model));
    };
    return Car;
}());
var SUV = /** @class */ (function (_super) {
    __extends(SUV, _super);
    function SUV(make, model, year, isOffRoadCapable) {
        var _this = _super.call(this, make, model, year) || this;
        _this.isOffRoadCapable = isOffRoadCapable;
        return _this;
    }
    SUV.prototype.toggleOffRoadCapability = function () {
        this.isOffRoadCapable = !this.isOffRoadCapable;
        console.log("Off-road mode is now ".concat(this.isOffRoadCapable ? "enabled" : "disabled", "."));
    };
    return SUV;
}(Car));
var mySUV = new SUV("Toyota", "Land Cruiser", 2023, false);
mySUV.displayInfo();
mySUV.toggleOffRoadCapability();
