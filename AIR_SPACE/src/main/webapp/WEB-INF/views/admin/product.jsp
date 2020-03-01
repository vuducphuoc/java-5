<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp" %>
<!DOCTYPE html>

<div class="product-manager" ng-app="myApp" ng-controller="productController">

    <%--HEAD START--%>
    <div class="content-head">
        <%-- Breadcrumb --%>
        <div class="pt-3 ">
            <nav aria-label="breadcrumb" style="background-color: #e9ecef;">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<c:url value='/admin/home' /> ">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><span>Quản lý sản phẩm</span></li>
                </ol>
            </nav>
        </div>
    </div>
    <%--HEAD END--%>

    <%--BODY START--%>
    <div class="content-body">
        <div class="table-product">
            <table class="table border">
                <thead>
                <tr class="border bg-info text-white">
                    <th scope="col" style="width: 50px">
                        <i class="fas fa-table"></i>
                    </th>
                    <th scope="col" colspan="5">Danh sách sản phẩm</th>
                </tr>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Giá tiền</th>
                    <th scope="col"> Ảnh sản phẩm</th>
                    <th scope="col"></th>
                    <th scope="col" class="text-center">
                        <input type="button" value="Thêm mới" class="btn btn-primary" ng-click="insert()">
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="product in products">
                    <th scope="row">{{$index +1}}</th>
                    <td>{{product.name}}</td>
                    <td>{{product.price}}</td>
                    <td>
                        <span ng-repeat="image in product.imagesList">
                            <img src="${pageContext.request.contextPath}/resources/images/{{image.name}}" alt="..."
                                 class="img-thumbnail" style="width: 50px; height: 50px">
                        </span>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary" ng-click="fnEditImage(product)">
                            Edit Image
                        </button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-secondary"
                                ng-click="onSelect(product)"><i class="fas fa-pencil-alt"></i></button>

                        <button type="button" class="btn btn-outline-secondary shadow ml-3"
                                ng-click="fnDeleteProduct(product)">
                            <i class="fas fa-trash-alt"></i>
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="modal fade" id="modal-product" tabindex="-1" role="dialog" aria-labelledby="modal-product-title"
             aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">

                <form id="product-form" class="needs-validation" novalidate>
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modal-product-title">Sản phẩm</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body">
                            <input type="hidden" id="inputId" name="id">

                            <div class="form-group row">
                                <label for="inputName" class="col-sm-2 col-form-label">Tên sản phẩm</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputName" name="name" required>
                                    <div class="invalid-feedback">
                                        Vui lòng nhập tên sản phẩm !
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="inputPrice" class="col-sm-2 col-form-label">Giá sản phẩm</label>
                                <div class="col-sm-4">
                                    <input type="number" class="form-control" id="inputPrice" name="price" value="0"
                                           required min="0">
                                    <div class="invalid-feedback">
                                        Vui lòng nhập giá !
                                    </div>
                                </div>
                            </div>


                            <div class="form-group row">
                                <label for="inputDescribes" class="col-sm-2 col-form-label">Mô tả</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control " id="inputDescribes" rows="3"
                                              name="describes"></textarea>
                                </div>

                            </div>

                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label" for="inputCategory">Danh mục </label>

                                <div class="col-auto">
                                    <select class="custom-select" id="inputCategory" name="categoryId">
                                        <option ng-repeat="category in categories" value="{{category.id}}">
                                            {{category.name}}
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" ng-click="saveOrUpdate()">Save changes
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="modal fade" id="modal-image" tabindex="-1" role="dialog" aria-labelledby="modal-image-title"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modal-image-title">Ảnh sản phẩm</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">
                        <form method="POST" enctype="multipart/form-data" id="fileUploadForm" class="needs-validation"
                              novalidate>
                            <div class="form-group row justify-content-end">
                                <div class="col-auto">
                                    <div>
                                        <div class="input-group">
                                            <input type="hidden" value="" name="productId" id="hidden-productId">
                                            <input type="hidden" value="" name="colorId" id="hidden-colorId">

                                            <div class="custom-file">
                                                <input type="file" required class="custom-file-input" id="inputFile"
                                                       aria-describedby="submit-uploadFile" name="image">
                                                <label class="custom-file-label" for="inputFile">Choose file</label>
                                                <div class="invalid-tooltip">
                                                    Vui lòng chọn ảnh !
                                                </div>
                                            </div>

                                            <div class="input-group-append">
                                                <button class="btn btn-outline-secondary" type="submit"
                                                        id="submit-uploadFile">Thêm
                                                </button>
                                            </div>

                                        </div>
                                    </div>
                                    <div>
                                        <!-- Bootstrap Progress bar -->
                                        <div class="progress">
                                            <div id="progressBar" class="progress-bar progress-bar-success"
                                                 role="progressbar"
                                                 aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: 0%">0%
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>

                        <div class="message-box">
                            <div class="alert alert-warning alert-dismissible fade d-none alert-uploadFile"
                                 role="alert">
                                <strong>Message !</strong> <span class="message-uploadFile"></span>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </div>

                        <form id="image-form" class="needs-validation" novalidate>
                            <table class="table">
                                <table class="table table-hover">
                                    <thead>

                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Ảnh</th>
                                        <th scope="col">Màu sắc</th>
                                        <th scope="col"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr ng-repeat="image in images">
                                        <th scope="row">{{$index +1}}</th>
                                        <td>
                                            <input type="hidden" value="{{image.id}}" name="images[]">
                                            <img src="${pageContext.request.contextPath}/resources/images/{{image.name}}"
                                                 alt="..." class="img-thumbnail" style="width: 50px; height: 50px">
                                        </td>
                                        <td>
                                            <select class="custom-select" name="colors[]">
                                                <option ng-repeat="color in colors" value="{{color.id}}"
                                                        ng-selected="image.colorId == color.id">{{color.name}}
                                                </option>
                                            </select>
                                        </td>
                                        <td>
                                            <button type="button" class="close" aria-label="Close"
                                                    ng-click="fnDeleteImage(image)">
                                                <span aria-hidden="true" style="font-size: 20px;">&times;</span>
                                            </button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </table>
                        </form>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" ng-click="fnSaveChangeImage()">Save changes
                        </button>
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

    myApp.controller('productController', ['$scope', '$http', function ($scope, $http) {
        var status = true;
        var index = 0;
        var image;

        $scope.products = JSON.parse(JSON.stringify(${productList}));

        $scope.categories = JSON.parse(JSON.stringify(${categoryList}));

        $scope.colors = JSON.parse(JSON.stringify(${colorList}));

        $scope.insert = function () {
            status = true;
            $scope.images = null;

            // remove validate
            $("#product-form").removeClass('was-validated');

            // reset form
            $("#product-form").trigger("reset");
            $('#inputId').val('');

            $('#modal-product').modal('show');
        }

        // ====== Select Product & Fill to modal ====== //
        $scope.onSelect = function (item) {
            $("#product-form").removeClass('was-validated');

            status = false;
            index = $scope.products.indexOf(item);

            fillToForm(item)

            $('#modal-product').modal('show');
        }

        // ====== Save Change Product ====== //
        $scope.saveOrUpdate = function () {

            if (validation(event, $('#product-form'))) {
                $http({
                    url: '${pageContext.request.contextPath}/admin/api/save-product',
                    method: 'POST',
                    params: $('#product-form').serializeObject()
                }).then(function (value) {
                    if (status == true) {
                        $scope.products.push(value.data);
                    } else {
                        $scope.products[index] = value.data;
                    }

                    $('.modal').modal('hide');
                })
            }
        }

        $scope.fnDeleteProduct = function (item) {
            var i = $scope.products.indexOf(item);
            var id = item.id;
            $http({
                url: '${pageContext.request.contextPath}/admin/api/delete-product',
                method: 'POST',
                params: {
                    id: id
                }
            }).then(function () {
                $scope.products.splice(i, 1);
            })
        }

        // ====== Get Image & Fill To Modal ====== //
        $scope.fnEditImage = function (item) {
            var id = item.id;
            index = $scope.products.indexOf(item);

            $http({
                url: '${pageContext.request.contextPath}/admin/api/edit-image',
                method: 'POST',
                params: {
                    id: id
                }
            }).then(function (value) {
                var data = value.data;
                $scope.images = JSON.parse(JSON.stringify(data.images));
                // $scope.colors = JSON.parse(JSON.stringify(data.colors));

                $('#hidden-productId').val(id);
                $('#hidden-colorId').val($scope.colors[0].id);
            })

            $('#modal-image').modal('show');
        }

        // ====== Save Change Image ====== //
        $scope.fnSaveChangeImage = function () {
            $http({
                url: '${pageContext.request.contextPath}/admin/api/save-change-image',
                method: 'POST',
                params: $('#image-form').serializeObject()
            }).then(function (value) {
                var data = JSON.parse(JSON.stringify(value.data))
                if (data.error == 'success') {
                    $('#modal-image').modal('hide');
                }
            })
        }

        $scope.fnDeleteImage = function (item) {
            var i = $scope.images.indexOf(item);

            $http({
                url: '${pageContext.request.contextPath}/admin/api/delete-image',
                method: 'POST',
                params: {
                    id: item.id
                }
            }).then(function () {
                $scope.images.splice(i, 1);
                $scope.products[index].imagesList.splice(i, 1);
            })
        }

        // ====== Upload Image ====== //
        $('#submit-uploadFile').click(function (event) {
            event.preventDefault();

            if (validation(event, $('#fileUploadForm'))) {
                image = $('#inputFile').val().split("\\").pop();
                uploadFile();
            }

        })

        function uploadFile() {
            // Get form
            var form = $('#fileUploadForm')[0];
            var formData = new FormData(form);

            // Ajax call for file uploaling
            var ajaxReq = $.ajax({
                url: '${pageContext.request.contextPath}/admin/api/upload-image',
                type: 'POST',
                data: formData,
                cache: false,
                contentType: false,
                processData: false,
                xhr: function () {
                    //Get XmlHttpRequest object
                    var xhr = $.ajaxSettings.xhr();

                    //Set onprogress event handler
                    xhr.upload.onprogress = function (event) {
                        var perc = Math.round((event.loaded / event.total) * 100);
                        $('#progressBar').text(perc + '%');
                        $('#progressBar').css('width', perc + '%');
                        $('.custom-file-label').text('Choose file');
                        $('#inputFile').val('');
                    };
                    return xhr;
                },
                beforeSend: function (xhr) {
                    //Reset alert message and progress bar
                    $('#progressBar').text('');
                    $('#progressBar').css('width', '0%');
                }
            });

            // Called on success of file upload
            ajaxReq.done(function (msg) {
                var productId = $('#hidden-productId').val();
                var colorId = $('#hidden-colorId').val();

                $http({
                    method: 'POST',
                    url: "${pageContext.request.contextPath}/admin/api/add-new-image",
                    params: {
                        name: image,
                        productId: productId,
                        colorId: colorId
                    }
                }).then(function (value) {
                    var data = JSON.parse(JSON.stringify(value.data))
                    if (typeof data.error !== "undefined") {
                        $('.alert-uploadFile.show').remove();

                        var $alert = $('.alert-uploadFile.d-none').clone();
                        $alert.find('.message-uploadFile').text(data.error.message);
                        $alert.removeClass('d-none');
                        $('.message-box').append($alert);
                        $alert.addClass('show');
                    } else {
                        $('#alert-uploadFile').addClass('d-none');
                        $scope.images.push(data.result);
                        $scope.products[index].imagesList.push(data.result);
                    }
                })
            });
        }

        // ============================================= //

        // Fill Data to form
        function fillToForm(data) {
            $('#inputId').val(data.id);
            $('#inputName').val(data.name);
            $('#inputPrice').val(data.price);
            $('#inputDescribes').val(data.describes);
            $('#inputCategory').val(data.category.id)
        }

        // validate form
        function validator(event) {
            var check = true;
            var forms = document.getElementsByClassName('needs-validation');
            var validation = Array.prototype.filter.call(forms, function (form) {

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

        // validate form
        function validation(event, forms) {
            var check = true;
            var validation = Array.prototype.filter.call(forms, function (form) {

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
        $.fn.serializeObject = function () {
            var o = {};
            var a = $(this).serializeArray();
            $.each(a, function () {
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

        $(".custom-file-input").on("change", function () {
            var fileName = $(this).val().split("\\").pop();
            $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
            //Reset alert message and progress bar
            $('#progressBar').text('');
            $('#progressBar').css('width', '0%');
        });
    }]);

</script>