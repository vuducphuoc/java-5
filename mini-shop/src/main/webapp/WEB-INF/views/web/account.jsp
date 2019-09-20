<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sản phầm chi tiết</title>
</head>

<body>
<div class="wrap">
    <div id="content" class="clearfix container pt-5 pb-5">
        <div id="account_information" class="content-pages">
            <div class="row">
                <!-- Side bar -->
                <div class="col-md-3" data-sticky_column="">
                    <div class="group_sidebar">
                        <div class="navbar-inner">

                            <div class="mega-left-title btn-navbar title-hidden-sm">
                                <h3 class="sb-title text-uppercase">tài khoản</h3>
                            </div>

                            <ul class="nav navs sidebar menu list-group" id="cssmenu">
                                <li class="list-group-item">
                                    <a href="<c:url value="/account" /> ">
                                        <span>Thông tin tài khoản</span>
                                    </a>
                                </li>

                                <li class="list-group-item">
                                    <a href="<c:url value="/account/address" />">
                                        <span>Danh sách địa chỉ</span>
                                    </a>
                                </li>

                                <li class="list-group-item">
                                    <a href="<c:url value="/account/logout"/>">
                                        <span>Đăng xuất</span>
                                    </a>
                                </li>
                            </ul>
                        </div>

                        <!-- Banner quảng cáo -->
                        <div class="list-group_l banner-left hidden-sm hidden-xs">
                        </div>
                    </div>
                </div>
                <%--END SIDE BAR--%>

                <!-- Chi tiết sản phẩm-->
                <div class="col-md-9">
                    <%--Title--%>
                    <div class="row text-center justify-content-center">
                        <h1 class="account_title text-uppercase">tài khoản của bạn</h1>
                    </div>

                    <%--Information--%>
                    <div class="row">
                        <div class="col">
                            <p class="title-detail">Thông tin tài khoản</p>
                            <h2 class="name_account">${accountLogin.getName()}</h2>
                            <p class="email_account">${accountLogin.getEmail()}</p>
                            <div class="address">
                                <a href="<c:url value="/account/address" />" class="view_address">Xem đại chỉ</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>

</html>
