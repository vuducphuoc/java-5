<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/taglib.jsp" %>

<div class="product-manager">

    <%--HEAD START--%>
    <div class="content-head">
        <%-- Breadcrumb --%>
        <div class="pt-3 ">
            <nav aria-label="breadcrumb" style="background-color: #e9ecef;">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<c:url value='/admin/home' /> ">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><span>Quản lý chi tiết sản phẩm</span></li>
                </ol>
            </nav>
        </div>
    </div>
    <%--HEAD END--%>

    <%--BODY START--%>
    <div class="content-body" ng-app="myApp" ng-controller="productDetailController">
        <form id="select-data" novalidate>
            <div class="form-group">
                <label for="select-category">Danh mục sản phẩm</label>
                <select class="custom-select" id="select-category" required>
                    <option value="">Chọn danh mục ...</option>
                    <option value="{{category.id}}" ng-repeat="category in categories">{{category.name}}</option>
                </select>
                <div class="invalid-feedback">
                    Mời bạn chọn danh mục sản phẩm
                </div>
            </div>

            <div class="form-group">
                <label for="select-product">Sản phẩm</label>
                <select class="custom-select" id="select-product" required>
                    <option value="">Chọn sản phẩm ...</option>
                    <option ng-repeat="product in products" value="{{product.id}}">{{product.name}}</option>
                </select>
                <div class="invalid-feedback">
                    Mời bạn chọn sản phẩm
                </div>
            </div>

            <div class="form-group text-right">
                <button class="btn btn-secondary" id="view-detail-btn">Xem chi tiết</button>
            </div>
        </form>

        <table class="table border table-hover">
                <thead>
                <tr class="border bg-info text-white">
                    <th scope="col" style="width: 50px">
                        <i class="fas fa-table"></i>
                    </th>
                    <th scope="col" colspan="4">Danh sách chi tiết sản phẩm</th>
                </tr>
                <tr class="bg-light">
                    <th scope="col">#</th>
                    <th scope="col">Màu sắc</th>
                    <th scope="col">Kích cỡ</th>
                    <th scope="col">Tồn kho</th>
                    <th scope="col"></th>
                </tr>
                <tr class="product-info d-none">
                    <th></th>
                    <th colspan="2">

                        <span id="product-name"></span>
                    </th>
                    <th>

                    </th>
                    <th style="width: 150px;" class="text-center ">
                        <button type="button" class="btn btn-outline-secondary shadow rounded-0" ng-click="fnShowModal(null)">
                            Thêm mới
                        </button>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="item in productDetails">
                    <th scope="row">{{$index + 1}}</th>
                    <td>{{item.color.name}}</td>
                    <td>{{item.size.name}}</td>
                    <td>{{item.quantity}}</td>
                    <td class="text-center">
                        <button type="button" class="btn btn-outline-secondary shadow" ng-click="fnShowModal(item)">
                            <i class="fas fa-pencil-alt"></i>
                        </button>

                        <button type="button" class="btn btn-outline-secondary shadow ml-3" ng-click="fnDeleteDetail(item)">
                            <i class="fas fa-trash-alt"></i>
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>

        <div class="modal fade" id="edit-detail-modal" tabindex="-1" role="dialog" aria-labelledby="modal-title" aria-hidden="true">
            <div class="modal-dialog" role="document">

                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modal-title"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">

                        <div class="message-box">
                            <div class="alert alert-warning alert-dismissible fade d-none alert-message" role="alert">
                                <strong>Message !</strong> <span class="message-text"></span>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </div>

                        <form id="detail-form" novalidate >
                            <input type="hidden" id="detail-id" name="id">
                            <input type="hidden" id="product-id" value="" name="productId">

                            <div class="form-group">
                                <label for="select-color">Màu sắc</label>
                                <select class="custom-select" id="select-color" required name="colorId">
                                    <option value="">Màu sắc ...</option>
                                    <option ng-repeat="item in colors" value="{{item.id}}">{{item.name}}</option>
                                </select>
                                <div class="invalid-feedback">
                                    Mời bạn chọn màu sắc !
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="select-size">Kích cỡ</label>
                                <select class="custom-select" id="select-size" required name="sizeId">
                                    <option value="">Size ...</option>
                                    <option ng-repeat="item in sizes" value="{{item.id}}">{{item.name}}</option>
                                </select>
                                <div class="invalid-feedback">
                                    Mời bạn chọn kích cỡ
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="input-quantity">Số lượng</label>
                                <input type="number" value="0" min="0" name="quantity" id="input-quantity" class="form-control ">
                                <div class="invalid-feedback">
                                    Mời bạn nhập số lượng !
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" ng-click="fnSaveDetail()">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <%--BODY END--%>

    <%--FOOTER START--%>
    <div class="content-foot">

    </div>
    <%--FOOTER END--%>
</div>

<script>
    var myApp = angular.module('myApp', []);

    myApp.controller('productDetailController',['$scope', '$http', function($scope, $http) {
        $scope.categories = JSON.parse(JSON.stringify(${categoryList}));
        $scope.colors = JSON.parse(JSON.stringify(${colorList}));
        $scope.sizes = JSON.parse(JSON.stringify(${sizeList}));

        var index = 0;
        var status = true;

        $scope.fnShowModal = function (item) {
            $('.alert-message.show').addClass('d-none');
            if (item == null) {
                status = true;
                $('#modal-title').text('Thêm mới chi tiết sản phẩm');
                $('#detail-id').val('');
                $('#select-color').val('');
                $('#select-size').val('');
                $('#input-quantity').val(0);
            } else {
                status = false;
                index = $scope.productDetails.indexOf(item);
                $('#modal-title').text('Cập nhật chi tiết sản phẩm');
                $('#detail-id').val(item.id);
                $('#select-color').val(item.color.id);
                $('#select-size').val(item.size.id);
                $('#input-quantity').val(item.quantity);
            }

            $('#edit-detail-modal').modal('show');
        }

        $scope.fnSaveDetail = function() {
            if (validation(event, $('#detail-form'))) {
                $http({
                    method: 'POST',
                    url: "${pageContext.request.contextPath}/admin/api/save-product-detail",
                    params: $('#detail-form').serializeObject()
                }).then(function (value) {
                    var data = JSON.parse(JSON.stringify(value.data));

                    if (status == true) {
                        if (typeof data.error !== "undefined") {
                            $('.alert-message.show').remove();

                            var $alert = $('.alert-message.d-none').clone();
                            $alert.find('.message-text').text(data.error.message);
                            $alert.removeClass('d-none');
                            $('.message-box').append($alert);
                            $alert.addClass('show');
                        } else {
                            $('.alert-message.show').addClass('d-none');
                            $scope.productDetails.push(data.result);
                            $('#edit-detail-modal').modal('hide');
                        }
                    } else {
                        $scope.productDetails[index] = data.result;
                        $('#edit-detail-modal').modal('hide');
                    }
                })


            }
        }

        $scope.fnDeleteDetail = function(item) {
            var i = $scope.productDetails.indexOf(item);
            var id = item.id;

            $http({
                method: 'POST',
                url: "${pageContext.request.contextPath}/admin/api/delete-product-detail",
                params: {
                    id: id
                }
            }).then(function () {
                console.log("Xóa thành công Id = " + id + "!");
                $scope.productDetails.splice(i, 1);
            })
        }

        $('#select-category').change(function () {
           var id = $('#select-category').val();

           $http({
               method: 'POST',
               url: "${pageContext.request.contextPath}/admin/api/get-product-by-category",
               params: {
                   categoryId: id
               }
           }).then(function (value) {
               var data = JSON.parse(JSON.stringify(value.data))
               $scope.products = data;
           })
       })

        $('#view-detail-btn').click(function () {

            if (validation(event, $('#select-data'))) {
                $('.product-info').removeClass('d-none');

                var id = $('#select-product').val();
                var name = $("#select-product :selected").text();

                $('#product-id').val(id);
                $('#product-name').text(name);

                $http({
                    method: 'POST',
                    url: "${pageContext.request.contextPath}/admin/api/get-detail-by-product",
                    params: {
                        productId: id
                    }
                }).then(function (value) {
                    var data = JSON.parse(JSON.stringify(value.data))
                    $scope.productDetails = data;
                })
            }
        })

        //======================== JS ====================//
        // validate form
        function validation(event, forms) {
            var check = true;
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

</script>
