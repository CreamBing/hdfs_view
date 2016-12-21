<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>hdfsV首页</title>
    <meta name="description" content="Bootstrap导航菜单">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="fragment" content="!"/>
    <meta name="author" content="bing"/>
    <link rel="stylesheet" href="/static/js/thirdPart/bootstrasp3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/global.css">
    <link rel="stylesheet" href="/static/css/index.css">
    <link rel="stylesheet" href="/static/js/thirdPart/bootstrap_select2/select2.min.css">
</head>
<body>
<#include "nav.ftl">
    <div class="container-fluid">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">
                <div id="searchData" ng-controller="searchCtrl">
                    <form ng-submit="searchData()">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="input-group">
                                    <select id="searchTips" ng-model="searchCont" class="form-control"></select>
                                         <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit">
                                                <span class="glyphicon glyphicon-search"></span>
                                            </button>
                                         </span>
                                </div><!-- /input-group -->
                            </div><!-- /.col-lg-6 -->
                        </div><!-- /.row -->
                    </form>
                </div>
            </div>
            <!-- Table -->
            <div ng-app="rootData" ng-controller="rootController">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>content</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="x in datas">
                        <td>{{ $index + 1 }}</td>
                        <td>{{x}}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
<#include "footer.ftl">
<script src="/static/js/thirdPart/angular1.6/angular.min.js"></script>
<script src="/static/js/thirdPart/jquery1.9.1/jquery-1.9.1.min.js"></script>
<script src="/static/js/thirdPart/bootstrasp3.3.1/js/bootstrap.min.js"></script>
<script src="/static/js/thirdPart/bootstrap_select2/select2.min.js"></script>

<script src="/static/js/module/index.js"></script>
</body>
</html>