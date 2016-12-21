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
);

$("#searchTips").select2({
    ajax: {
        url: "http://localhost:8080/data/searchTips",
        delay: 250,
        processResults: function (data) { // parse the results into the format expected by Select2.
            // since we are using custom formatting functions we do not need to alter the remote JSON data
            console.log("data"+data);
            console.log("data"+data.mac);
            console.log("data"+data['mac']);
            return { results: data.mac};
        },
        cache: true
    },
    escapeMarkup: function (markup) { return markup; }, // let our custom formatter work
    minimumInputLength: 1,
    language: "zh-CN", //设置 提示语言
    templateResult: function (repo) { //搜索到结果返回后执行，可以控制下拉选项的样式
        console.log("====================templateResult开始==================");
        console.log(repo.mac);
        console.log("====================templateResult结束==================");
        if (repo.loading) return repo.mac;
        var markup = "<div class=''>" + repo.mac + "</div>";
        return markup;
    },
    templateSelection: function (repo) {  //选中某一个选项是执行
        console.log("------------------templateSelection开始-------------------------------------");
        console.log( repo);
        console.log("------------------templateSelection结束-------------------------------------");
        return repo.mac;
    }
});