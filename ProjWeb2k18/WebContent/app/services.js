 myApp.factory('itemsFactory', function ($http) {
    var factory = {}

    var config = {
        headers: {
            'Content-Type': 'application/json'
        }
    };


factory.getAll = function () {
        return $http.get('http://localhost:8080/WebProj2k18/webapi/Artikal');
    };
    
    return factory;
 });