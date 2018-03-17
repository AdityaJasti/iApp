app.service("UserLoginService", function($http, $q) {
	return ({
		validateUser : validateUser/*,
		logOutUser : logOutUser*/
	});
	
	// error handling function
	function handleError(response) {
		if (!angular.isObject(response.data) || !response.data.message) {
			return ($q.reject("An unknown error occurred."));
		}
		//return ($q.reject(response.data.message));
		return (response.data);
	}
	//success handling function
	function handleSuccess(response) {
		return (response.data);
	}
	
	//Load Technologies related to client on request
	function validateUser(userInfo){
		var request = $http({
			method : "post",
			url : "User/Login",
			async: true,
            cache: false,
            data : JSON.stringify(userInfo)
		});

		return (request.then(handleSuccess, handleError));
	}
	
	//Logout user from the application
	/*function logOutUser(userSession){
		var request = $http({
			method : "post",
			url : "User/LogOut",
			async: true,
            cache: false,
            data : JSON.stringify(userSession)
		});

		return (request.then(handleSuccess, handleError));
	}*/
	
});