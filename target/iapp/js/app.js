var app = angular.module('iApp', ['ngRoute','ngSanitize','ngStorage']);

//Configure routing based on url's requests
app.config(['$locationProvider', '$routeProvider', '$httpProvider', function($locationProvider, $routeProvider, $httpProvider, $rootScope, $location) {
	$httpProvider.defaults.cache = false;    
	if (!$httpProvider.defaults.headers.get) {
	$httpProvider.defaults.headers.get = {};
	}
	$httpProvider.defaults.headers.get['If-Modified-Since'] = '0';
	$routeProvider.when('/',{
		templateUrl: 'html/loginPage.html',
		controller: 'userLoginController'
	}).when('/Admin',{
		templateUrl: 'html/adminHome.html',
		controller: 'adminHomeController'
	}).when('/ScoreBoard',{
		templateUrl: 'html/ScoreBoard.html',
		controller: 'ScoreBoardController'
	}).otherwise({
        redirectTo: "/"
    });
	
	//$locationProvider.html5Mode(true).hashPrefix('!');
	$locationProvider.html5Mode(true);
	
	/*$rootScope.$on('$stateChangeStart', 
	   function(event, toState, toParams, fromState, fromParams){ 
	      event.preventDefault();
	      window.history.forward();
	});*/
	
}]);