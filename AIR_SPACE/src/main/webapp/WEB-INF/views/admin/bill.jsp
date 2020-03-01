<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/taglib.jsp" %>

<div id="manager-bill" ng-app="myApp" ng-controller="billController">

    <%--HEAD START--%>
    <div class="content-head">
        <%-- Breadcrumb --%>
        <div class="pt-3 ">
            <nav aria-label="breadcrumb" style="background-color: #e9ecef;">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<c:url value='/admin/home' /> ">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><span>Quản lý hóa đơn</span></li>
                </ol>
            </nav>
        </div>
    </div>
    <%--HEAD END--%>

    <div class="content-body">
        <div class="table-bill">
            <table class="table border">
                <thead>
                <tr class="border bg-info text-white">
                    <th scope="col" style="width: 50px">
                        <i class="fas fa-table"></i>
                    </th>
                    <th scope="col" colspan="4">Danh sách hóa đơn</th>
                </tr>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Khách hàng</th>
                    <th scope="col">Tổng tiền</th>
                    <th scope="col">Tình trạng</th>
                    <th scope="col" class="text-center">
                        <button type="button" class="btn btn-outline-success" ng-click="">
                            <i class="fas fa-plus"></i>
                        </button>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="item in bills">
                    <th scope="row">{{$index +1}}</th>
                    <td>{{item.user.name}}</td>
                    <td>{{item.total | currency:'':0}} VNĐ</td>
                    <td>
                        {{getStatus(item.status)}}
                    </td>
                    <td class="text-center">
                        <button type="button" class="btn btn-outline-secondary shadow" ng-click="viewDetail(item.id)">
                            <i class="fas fa-eye"></i>
                        </button>

                        <button type="button" class="btn btn-outline-secondary shadow ml-2 mr-2" ng-click="editStatus(item.id)">
                            <i class="fas fa-pencil-alt"></i>
                        </button>

                        <button type="button" class="btn btn-outline-secondary shadow">
                            <i class="fas fa-times"></i>
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="modal fade" id="billDetail-modal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Hóa đơn chi tiết</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">

                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" ng-click="saveOrUpdate()">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="changeStatus-modal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog p-5" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Thay đổi trạng thái</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <input type="hidden" name="id" id="id">
                        <div class="form-group">
                            <select name="status" id="status" class="custom-select">
                                <option value="1">Đơn mới</option>
                                <option value="2">Đang vận chuyển</option>
                                <option value="3">Đã nhận hàng</option>
                            </select>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" ng-click="saveOrUpdate()">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="content-foot">

    </div>
</div>

<script>
    var myApp = angular.module('myApp', []);

    myApp.controller('billController', ['$scope', '$http', function ($scope, $http) {
        $scope.bills = JSON.parse(JSON.stringify(${billList}));

        $scope.viewDetail = function (id) {
            $('#billDetail-modal').modal('show');
        }

        $scope.editStatus = function (id) {
            $('#changeStatus-modal').modal('show');
        }

        $scope.getStatus = function (i) {
            var status;
            switch (i) {
                case 1:
                    status = 'Đơn mới';
                    break;
                case 2:
                    status = 'Đang vận chuyển';
                    break;
                case 3:
                    status = 'Đã nhận hàng';
                    break;
            }
            return status;
        }


    }]);
</script>
