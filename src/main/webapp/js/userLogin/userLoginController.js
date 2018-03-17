//Login controller
app.controller('userLoginController', ['$rootScope', '$location', '$scope','$http','$sessionStorage','$window','UserLoginService',function($rootScope,$location,$scope,$http,$sessionStorage,$window,UserLoginService){
	
	$scope.username = '';
	$scope.password = '';
	
	$scope.logoutRes = '';
	
	//$scope.emptyFields = 'Please Enter credentials';
	
	
	
	$scope.onLoad = function(){
		$(window).load(function(){
	        $('#logOutMessage').hide();
	        $("#loginErrorMessage").hide();
	        return false;
	    });
		
		//$('#logOutMessage').hide();
		/*if(($sessionStorage.userInfo.message != null || $sessionStorage.userInfo.message != '')){
			
			if($sessionStorage.userInfo.userID == 1){
				$("#loginErrorMessage").hide();
				//console.log("logged out "+$sessionStorage.userInfo.userID);
			}else{
				console.log("invalid login "+$sessionStorage.userInfo.userID);
			}
			
			 $('#logOutMessage').show();
			 $("#loginErrorMessage").hide();
			$scope.logoutRes = $sessionStorage.userInfo.message;
			$sessionStorage.userInfo.sessionID = null;
			$sessionStorage.userInfo.validSession = false;
			$sessionStorage.userInfo.message = null;
		}*/
		/*if($sessionStorage.userInfo.userID === 11){
			$scope.logoutRes = $sessionStorage.userInfo.message;
		}else{
			
		}*/
	}
	
	//Valdiate and user login
	$scope.validate = function(username,password){
		
		if((username == null && password ==null) || (username == '' && password == '') || (username == undefined && password == undefined)){
		
			$("#loginErrorMessage").hide();
			$('#logOutMessage').hide();
		}else{
			$("#loginErrorMessage").hide();
			var userInfo = {
		            "username": username,
		            "password": password
		        };
			
			UserLoginService.validateUser(userInfo).then(function(responseData){
				console.log("In controller ---"+username + "----"+password);
				$scope.resultData = responseData;
				console.log("Login ---------->"+JSON.stringify(responseData));
				$sessionStorage.userInfo = responseData;
				console.log("$sessionStorage ---------->"+JSON.stringify($sessionStorage.userInfo.sessionID));
				if($scope.resultData.userrole ==='ADMIN'){
					$location.path('/Admin');
					
				}else if($scope.resultData.userrole ==='SCORE'){
					$rootScope.matchInfo = responseData;
					$sessionStorage.matchInfoData = $rootScope.matchInfo;
					$location.path('/ScoreBoard');
				}else{
					$location.path('/');
					/*if($sessionStorage.userInfo.userID == 0){
						$('#logOutMessage').hide();
						console.log("invalid login "+$sessionStorage.userInfo.userID);
					}else{}*/
					$("#loginErrorMessage").show();
					$('#logOutMessage').hide();
					console.log("login failed ---------->"+JSON.stringify(responseData.message));
				}
			});
		}
	}
	
	//Logout active user from the application
	/*$scope.userLogout = function(){
		
		var userSession ={
            "sessionID": $sessionStorage.userInfo.sessionID
        };
		
		UserLoginService.logOutUser(userSession).then(function(logOutResponse){
			$scope.logoutRes = logOutResponse;
			console.log("IN Logout service --"+JSON.stringify(logOutResponse));
			if($scope.logoutRes.validSession === false){
				console.log("IN Logout service --"+JSON.stringify($scope.logoutRes.validSession));
				//$sessionStorage.userInfo.message = $scope.logoutRes.message;
				$location.path('/');
			}
		});
	}*/
	
	
	
	
	
}]);