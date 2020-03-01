<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/taglib.jsp" %>
<!DOCTYPE html>

<!-- Chi tiết sản phẩm-->
<div class="col-md-9">
    <%--Title--%>
    <div class="row text-center justify-content-center">
        <h1 class="account_title text-uppercase">Tài khoản của bạn</h1>
    </div>

    <%--Information--%>
    <div class="row">
        <div class="col">
            <p class="title-detail">Thông tin tài khoản</p>
            <h2 class="name_account">${userLogin.name}</h2>
            <p class="email_account">${userLogin.email}</p>
            <div class="chang-password">
                <a href="<c:url value="/account/change-password" />">Đổi mật khẩu</a>
            </div>
        </div>
    </div>
</div>
