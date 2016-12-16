var app = angular.module('rootData', []);
app.controller('rootController', function ($scope, $http) {
    $http({
        method: 'GET',
        url: 'http://localhost:8080/data/root'
    }).then(function successCallback(response) {
        $scope.datas = response.data.content;
    }, function errorCallback(response) {

    });
});