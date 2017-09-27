app.service("crudService", function ($http) {
	var serviceUrl = "/service";

	//get All Users
    this.getUsers = function () {
        return $http.get(serviceUrl + "/user/list");
    };

	this.getUser = function(userId) {
		var response = $http({
			method	: "POST",
			url		: serviceUrl + "getUser.php",
			params 	: {
					id : userId
			}
		});
		return response;
	};

	this.updateUser = function (user) {
		var response = $http({
			method : "POST",
			url : serviceUrl + "updateUser.php",
			params : user
		});

		return response;
	};

	this.addUser = function (user) {
		var response = $http({
			method  : "POST",
			url		: serviceUrl + "createUser.php",
			params : user
		});
		return response;
	};

	this.deleteUser = function (id) {
		var response = $http({
			method  : "POST",
			url		: serviceUrl + "deleteUser.php",
			params : {userId : id}
		});
		return response;
	};

});