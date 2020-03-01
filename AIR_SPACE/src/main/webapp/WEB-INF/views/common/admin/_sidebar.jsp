<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../taglib.jsp" %>

<!DOCTYPE html>

<div class="group_sidebar">

    <div id="sidebar" class="overflow-hidden">
        <div class="sb-title">
            <h3 class="sb-title-text">Menu</h3>
        </div>

        <ul class="sb-menu list-group list-group-flush">

            <li class="list-group-item sb-menu-item">
                <a href="<c:url value="/"/> " class="sb-btn">
                    Trang chủ
                </a>
            </li>

            <li class="list-group-item sb-menu-item">
                <a href="" class="sb-btn">
                    Quản trị hệ thống
                </a>
            </li>

            <li class="list-group-item sb-menu-item" >
                <a href="#collapseOne" data-toggle="collapse" data-target="#collapseOne"
                   aria-expanded="true" class="sb-btn">
                    Danh mục
                    <span class="float-right dropdown-toggle"></span>
                </a>

                <div class="list-group sub-menu collapse" id="collapseOne" data-parent="#sidebar">
                    <a class="list-group-item" href="<c:url value="/admin/tai-khoan" />">
                        Danh sách Tài khoản
                    </a>
                    <a class="list-group-item" href="<c:url value="/admin/san-pham"/> ">
                        Danh sách Sản phẩm
                    </a>
                    <a class="list-group-item" href="<c:url value="/admin/san-pham-chi-tiet"/> ">
                        Chi tiết sản phẩm
                    </a>
                    <a class="list-group-item" href="#">
                        Danh sách Hóa đơn
                    </a>
                </div>
            </li>
        </ul>
    </div>

    <!-- Banner quảng cáo -->
    <div class="list-group_l banner-left hidden-sm hidden-xs">
    </div>
</div>
