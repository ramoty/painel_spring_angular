angular.module('App',['ngRoute', 'App.Home', 'App.Usuarios'])
.config(function($locationProvider, $routeProvider){
    $locationProvider.html5Mode(true);
    $routeProvider
    .when('/', {
        redirectTo: "/home"
    })
    .when('/home', {
        templateUrl: './pages/home.html',
        controller: "HomeController"
    })
    .when('/usuarios', {
        templateUrl: './pages/usuario.html',
        controller: "UsuarioController"
    })
})