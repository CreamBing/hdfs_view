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

function searchData(){

}
//搜索
var searchData = angular.module('searchData', []);
searchData.controller('searchCtrl', function ($scope, $http) {
    $scope.searchData = function (search) {
        if(search!=null&&search!=""){
            $scope.searchCont=search;
        }
        $http({
            method: 'POST',
            data:{"searchCont":$scope.searchCont},
            url: 'http://localhost:8080/data/search'
        }).then(function successCallback(response) {
            var $scope = angular.element(document.getElementById('rootData')).scope();
            $scope.$apply(function () {
                $scope.datas = response.data.content;
            })
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
        dataType: 'json',
        delay: 250,
        data: function (params) {
            return {
                q: params.term, // search term
                page: params.page
            };
        },
        processResults: function (data, params) {
            // parse the results into the format expected by Select2
            // since we are using custom formatting functions we do not need to
            // alter the remote JSON data, except to indicate that infinite
            // scrolling can be used
            params.page = params.page || 1;

            return {
                results: data.items,
                pagination: {
                    more: (params.page * 30) < data.total_count
                }
            };
        },
        cache: true
    },
    escapeMarkup: function (markup) { return markup; }, // let our custom formatter work
    minimumInputLength: 1,
    templateResult: formatRepo2, // omitted for brevity, see the source of this page
    templateSelection: formatRepoSelection
});

function formatRepo2(repo) {
    if (repo.loading) return repo.text;
    var markup = "<div class=''>"+ repo.path + "</div>";
    return markup;
}

function formatRepoSelection (repo) {
    //查询，不要查询按钮
    var datass = $("#searchTips").select2('data');
    angular.element(document.getElementById('searchData')).scope().searchData(datass[0].path);
    console.log(datass[0].path);
    return repo.path || repo.text;
}
