var myApp = angular.module('myApp', ['ngRoute', 'ngStorage']);

myApp.config(function($routeProvider, $locationProvider) {

	$routeProvider.when('/',{
		templateUrl: 'partials/artikal.html'
	}).when('/artikal',{
		templateUrl: 'partials/artikal.html'
	
	});
});

myApp.config(function($logProvider){
    $logProvider.debugEnabled(true);
});