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
</head>
<body>
<#include "nav.ftl">
<div class="container-fluid">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">HDFS</div>
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

<script src="/static/js/module/index.js"></script>
</body>
</html>