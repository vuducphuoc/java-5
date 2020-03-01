<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp" %>
<!DOCTYPE html>

<%-- Breadcrumb --%>
<div class="pt-3">
    <nav aria-label="breadcrumb" style="background-color: #e9ecef;">
        <ol class="breadcrumb container">
            <li class="breadcrumb-item"><a href="<c:url value='/' /> ">Trang chủ</a></li>
            <li class="breadcrumb-item active"><span>Đăng nhập</span></li>
        </ol>
    </nav>
</div>

<div id="login-content">
    <div class="container pb-5 pt-4">
        <div class="row justify-content-center ">
            <form class="shadow rounded col-md-5 text-center border pt-5 needs-validation" novalidate
                  method="POST"  action="<c:url value="/login" /> ">

                <h3>ĐĂNG NHẬP</h3>

                <p class="text-sm-left text-muted font-italic pb-4" style="font-Size_Entity: 12px; font-weight: 500">
                    Đăng nhập vào tài khoản AIR SPACE của bạn:</p>

                <c:if test="${param.error == true}">
                    <div class="alert alert-warning alert-dismissible fade show" role="alert" id="error-message">
                            Tên đăng nhập hoặc mật khẩu không chính xác!
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>

                <div class="form-group md-form">
                    <input type="email" class="form-control" id="email" name="email" placeholder="email@example.com"
                           required value="${param.email}">
                    <div class="invalid-feedback text-left">
                        Vui lòng nhập email
                    </div>
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password" placeholder="password"
                           required minlength="6" maxlength="20" value="${param.password}">
                    <div class="invalid-feedback text-left">
                        Vui lòng nhập mật khẩu
                    </div>
                </div>

                <div class="form-group pt-2">
                    <input type="submit" class="col-12 btn btn-success text-uppercase" id="btnLogin" value='đăng nhập'>
                    <input type="reset" class="col-12 btn btn-success text-uppercase d-none" id="btnReset" value='Reset'>
                </div>
                <div class="form-group">
                    <p class="text-right pt-2"><a href="">Quên mật khẩu ?</a></p>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>


