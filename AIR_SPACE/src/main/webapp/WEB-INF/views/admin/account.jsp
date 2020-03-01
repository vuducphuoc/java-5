<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/taglib.jsp" %>

<div id="manager-account" ng-app="myApp" ng-controller="usersController">
    <%--HEAD START--%>
    <div class="content-head">
        <%-- Breadcrumb --%>
        <div class="pt-3 ">
            <nav aria-label="breadcrumb" style="background-color: #e9ecef;">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<c:url value='/admin/home' /> ">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><span>Quản lý tài khoản</span></li>
                </ol>
            </nav>
        </div>
    </div>
    <%--HEAD END--%>

    <div class="row m-0">

        <div class="col-md-6">
            <div class="form-group row">
                <label class="col-md-3 col-form-label">Số lượng hiển thị</label>
                <select class="form-control col-md-6">
                    <option value="5" selected>5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                </select>
            </div>
        </div>

        <div class="col-md-6">
            <div class="form-group row">
                <label for="txtSearch" class="col-md-3 col-form-label">Tìm kiếm</label>
                <input type="text" ng-model="inputSearch" class="form-control col-md-6" id="txtSearch" placeholder="Từ khóa...">
            </div>
        </div>
    </div>

    <div class="row m-0">
        <table class="table table-hover border">
            <thead>
                <tr class="border bg-info text-white">
                    <th scope="col" style="width: 50px">
                        <i class="fas fa-table"></i>
                    </th>
                    <th scope="col" colspan="5">Danh sách tài khoản</th>
                </tr>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Họ và tên</th>
                    <th scope="col">Email</th>
                    <th scope="col">Tình trạng</th>
                    <th scope="col">Vai trò</th>
                    <th scope="col" class="text-center">
                        <input type="button" value="Thêm mới" class="btn btn-primary user-insert-btn" ng-click="insert()">
                    </th>
                </tr>
            </thead>

            <tbody>
                <tr ng-repeat="item in users | filter : {name : inputSearch }">
                    <th scope="row">{{$index +1}}</th>
                    <td>{{item.name}}</td>
                    <td>{{item.email}}</td>
                    <td>{{item.status == 0 ? 'InActive' : 'Active'}}</td>
                    <td>
                        <span ng-show="item.roles[0] == 1"> Admin </span>
                        <span ng-show="item.roles[0] == 2"> User </span>

                        <span ng-show="item.roles.length == 2">
                            / <span ng-show="item.roles[1] == 2"> User </span>
                        </span>


                    </td>
                    <td class="text-center">

                        <button type="button" class="btn btn-outline-secondary shadow"
                                ng-click="onSelect(item)">
                            <i class="fas fa-pencil-alt"></i>
                        </button>

                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <div class="modal fade" id="modal-account" tabindex="-1" role="dialog" aria-labelledby="modal-account-title" aria-hidden="true">
        <div class="modal-dialog" role="document">

            <form id="user-form" class="needs-validation" novalidate>
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modal-account-title">Account</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <input type="hidden" value="" id="inputId" name="id">

                    <div class="form-group row">
                        <label for="inputName" class="col-sm-2 col-form-label">Họ và tên</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputName" name="name" value="" required>
                            <div class="invalid-feedback">
                                Vui lòng nhập họ tên !
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="inputEmail" name="email" value="" required>
                            <div class="invalid-feedback">
                                Vui lòng nhập một email !
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">Mật khẩu</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword" name="password" value="" required>
                            <div class="invalid-feedback">
                                Vui lòng nhập password !
                            </div>
                        </div>
                    </div>

                    <div class="form-group row align-items-center">
                        <label class="col-sm-2 col-form-label">Vai trò</label>
                        <div class="col-auto">
                            <div class="custom-control custom-checkbox custom-control-inline">
                                <input type="checkbox" class="custom-control-input" name="roles" value="1" id="customCheckAdmin" required>
                                <label class="custom-control-label" for="customCheckAdmin">Admin</label>
                            </div>

                            <div class="custom-control custom-checkbox custom-control-inline">
                                <input type="checkbox" class="custom-control-input" name="roles" value="2" id="customCheckUser" required>
                                <label class="custom-control-label" for="customCheckUser">User</label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row align-items-center">
                        <label class="col-sm-2 col-form-label">Status</label>
                        <div class="col-auto">
                            <div class="custom-control custom-switch">
                                <input type="checkbox" class="custom-control-input" id="inputStatus" name="status" value="1">
                                <label class="custom-control-label" for="inputStatus">Active</label>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary user-save-change-btn">Save changes</button>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>

<script>
    var myApp = angular.module('myApp', []);

    myApp.controller('usersController',['$scope', '$http', function($scope, $http) {
        $scope.model = {};
        $scope.users = JSON.parse(JSON.stringify(${userList}));

        console.log($scope.users)

        $scope.onSelect = function (item) {
            $scope.model = item;

            // remove validate
            $("#user-form").removeClass('was-validated');

            // reset form
            $("#user-form").trigger("reset");

            $('#inputPassword').removeAttr('required');

            var userId = $scope.model.id;

            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath}/admin/api/edit-user',
                data: {
                    userId : userId
                }, success: function (user) {
                    $('#inputId').val(user.id);
                    $('#inputName').val(user.name);
                    $('#inputEmail').val(user.email);

                    if (user.status == 1) {
                        $('#inputStatus').prop('checked', true);
                    } else {
                        $('#inputStatus').prop('checked', false);
                    }

                    $('#customCheckAdmin').prop('checked', false)
                    $('#customCheckUser').prop('checked', false)

                    $.each(user.roles, function (index, value) {
                        console.log($('#customCheckAdmin').val())

                        if ($('#customCheckAdmin').val() == value) {
                            $('#customCheckAdmin').prop('checked',true)
                        }

                        if ($('#customCheckUser').val() == value) {
                            $('#customCheckUser').prop('checked',true)
                        }
                    })

                    $('#modal-account').modal('show');
                }
            })

        }

        $scope.insert = function (){
            // remove validate
            $("#user-form").removeClass('was-validated');

            // reset form
            $("#user-form").trigger("reset");
            $('#inputId').val('');
            $('#inputPassword').attr('required', true);

            // show form
            $('#modal-account').modal('show');
        }

        // Save change
        $('.user-save-change-btn').click(function () {
            var error = validator(event);
            if (error === true) {
                var id = $('#inputId').val();
                var status = true;
                var url = '';

                if (id == '') {
                    $('#inputId').val(0);
                    url = '${pageContext.request.contextPath}/admin/api/save-user';
                    status = true;
                } else {
                    url = '${pageContext.request.contextPath}/admin/api/update-user';
                    status = false;
                }

                $http({
                    url: url,
                    method: 'POST',
                    params: $('#user-form').serializeObject()
                }).then(function (value) {
                    var user = JSON.parse(JSON.stringify(value.data));
                    console.log(user)
                    if (status == true) {
                        $scope.users.push(user);
                    } else {
                        var index = $scope.users.indexOf($scope.model);
                        $scope.users[index] = user;
                    }
                    $('.modal').modal('hide');
                })
            }
        })

        // validate form
        function validator(event) {
            var check = true;
            var forms = document.getElementsByClassName('needs-validation');
            var validation = Array.prototype.filter.call(forms, function(form) {

                if ($("[name='roles']:checked").length == 0) {
                    $("[name='roles']").attr('required', true);
                } else {
                    $("[name='roles']").attr('required', false);
                }

                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();

                    form.classList.add('was-validated');
                    check = false;
                } else {
                    form.classList.remove('was-validated')
                }
            });
            return check;
        }

        // Change Data Form To JSON
        $.fn.serializeObject = function() {
            var o = {};
            var a = $(this).serializeArray();
            $.each(a, function() {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
    }]);

    $(function () {

        $("[name='roles']").change(function () {
            if ($("[name='roles']:checked").length == 0) {
                $("[name='roles']").attr('required', true);
            } else {
                $("[name='roles']").attr('required', false);
            }
        })
    })

</script>
