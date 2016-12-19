//列表显示
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


//搜索
var searchData = angular.module('searchData', []);
searchData.controller('searchCtrl', function ($scope, $http) {
    $scope.searchData = function () {
        $http({
            method: 'POST',
            data:{"searchCont":$scope.searchCont},
            url: 'http://localhost:8080/data/search'
        }).then(function successCallback(response) {
        }, function errorCallback(response) {

        });
    }

});

//一个页面两个ng-app
angular.element(document).ready(
    function (){
        angular.bootstrap(document.getElementById("searchData"), ["searchData"]);
    }
)