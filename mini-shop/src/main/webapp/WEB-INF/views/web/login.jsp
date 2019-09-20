<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ĐĂNG NHẬP</title>
</head>
<body>

<div id="login-content">
    <div class="container pb-5">
        <div class="row justify-content-center pt-5">
            <form id="accountDTO-login" class="col-md-5 text-center border pt-5 needs-validation " novalidate method="POST"
                  action="<c:url value="/login" />">
                <h3>ĐĂNG NHẬP</h3>
                <p class="text-sm-left text-muted font-italic pb-4" style="font-Size_Entity: 12px; font-weight: 500">
                    Đăng nhập vào tài khoản AIR SPACE của bạn:</p>

                <div class="form-group md-form">
                    <input type="email" class="form-control" id="email" name="email" placeholder="email@example.com"
                           required value="${param.email}">
                    <div class="invalid-feedback text-left">
                        Vui lòng nhập email
                    </div>
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password" placeholder="password"
                           required value="${param.password}">
                    <div class="invalid-feedback text-left">
                        Vui lòng nhập mật khẩu
                    </div>
                </div>

                <div class="form-group text-left">
                    <div class="text-danger">
                        ${error}
                    </div>
                </div>

                <div class="form-group pt-2">
                    <input type="submit" class="col-12 btn btn-success text-uppercase" id="btnLogin" value='đăng nhập'>
                    <p class="text-right pt-2"><a href="">Quên mật khẩu ?</a></p>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>