<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../taglib.jsp" %>

<!-- Side bar -->
<div class="col-md-3" data-sticky_column="">
    <div class="group_sidebar">
        <div class="navbar-inner">

            <div class="mega-left-title btn-navbar title-hidden-sm">
                <h3 class="sb-title text-uppercase">tài khoản</h3>
            </div>

            <ul class="nav navs sidebar menu list-group list-group-flush" id="cssmenu">
                <li class="list-group-item">
                    <a href="<c:url value="/account" /> ">
                        <span>Thông tin tài khoản</span>
                    </a>
                </li>

                <li class="list-group-item">
                    <a href="<c:url value="/account/my-cart" />">
                        <span>Giỏ hàng của tôi</span>
                    </a>
                </li>

                <li class="list-group-item">
                    <a href="<c:url value="/logout"/>">
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

