myApp.controller('prikazArtikalController', function ($scope, itemsFactory, $location, postNewItemFactory) {
    function init() {
        itemsFactory.getAll().success(function (data) {
            $scope.allItems = data;
        });
    }

    $scope.go = function (id) {
        $location.path('/updateitem/' + id);
    }

    $scope.delete = function (id) {
        postNewItemFactory.deleteItem(id).success(function (data) {
            toast('Successfully deleted item!');
            init();
        });
    };
    init();
});