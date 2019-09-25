<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<div class="container">
    <div class="jumbotron" ng-app="myapp">
        <h1 class="display-4">Java 5 - Lab06!</h1>
        <hr class="my-4">
        <div class="row" ng-controller="usersController">
            <div class="col-md-4">
                <form  ng-model="user" id="form-user">
                    <div class="form-group">
                        <label for="username">Email</label>
                        <input type="text" class="form-control" id="id" name="id" ng-model="user.id" ng-show="false" >
                        <input type="email" class="form-control" id="username" name="username" ng-model="user.username" ng-model-options="{updateOn : 'false'}"
                               placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" ng-model="user.password"
                               placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label for="fullname">Fullname</label>
                        <input type="text" class="form-control" id="fullname" name="fullname" ng-model="user.fullname" placeholder="Fullname">
                    </div>
                    <input type="button" value="Thêm mới" id="btn-insert" class="btn btn-primary">
                    <input type="button" value="Cập nhật" ng-click="action('update')" class="btn btn-primary">
                    <input type="button" value="Test" id="btn-test" class="btn btn-primary">
                </form>
            </div>
            <div class="col-md-8">
                <div class="row">
                    <div class="form-group">
                        <input type="text" ng-model="txtSearch" class="form-control">
                        <select class="form-control" ng-model="selectNumber">
                            <option value="" >-- Tất cả! --</option>
                            <option value="5" >5</option>
                            <option value="10">10</option>
                            <option value="15">15</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <table class="table table-hover bg-white">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Username</th>
                            <th scope="col">Password</th>
                            <th scope="col">Fullname</th>
                        </tr>
                        </thead>
                        <tbody >
                        <tr ng-repeat="item in users | filter : txtSearch | limitTo : selectNumber" ng-click="onSelect(item)">
                            <th scope="row">{{$index +1}}</th>
                            <td>{{item.username}}</td>
                            <td>{{item.password}}</td>
                            <td>{{item.fullname}}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    var myapp = angular.module("myapp", []);

    myapp.controller('usersController',['$scope', '$http', function($scope, $http) {
        $scope.users = [];
        $scope.users = JSON.parse(JSON.stringify(${list}));

        $scope.onSelect = function (user) {
            $scope.user = user;
        }

        $('#btn-insert').click(function () {
            $('#id').val(-1);

            $.ajax({
                url: 'user/save',
                type: 'POST',
                data: $('#form-user').serialize(),
                success: function (value) {
                    var user = JSON.parse(JSON.stringify(value));
                    $scope.users.push(user);
                    window.location.reload();
                }
            })
            // $http({
            //     method: 'POST',
            //     url: 'user/save',
            //     params: $('#form-user').serialize()
            // }).then(function (value) {
            //     var user = JSON.parse(JSON.stringify(value));
            //     $scope.users.push(user);
            // })
        })
    }]);

</script>
</body>
</html>
