<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../taglib.jsp" %>

<!DOCTYPE html>

<!-- Navigator -->
<div class="navbar navbar-expand-sm" id="navigator">
    <div class="container pl-0 pr-0">
        <div class="col-md-8">
            <!-- Links -->
            <ul class="navbar-nav">
                <!-- Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link text-uppercase" href="<c:url value="/collections/hang-moi-ve"/> "> Hàng mới về </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link text-uppercase" href="<c:url value="/collections/top-san-pham-ban-chay" />">Sản phẩm bán chạy</a>
                </li>

                <!-- Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop2" data-toggle="dropdown"> SẢN PHẨM </a>
                    <div class="dropdown-menu">
                        <c:forEach var="item" items="${listMenuItem}">
                            <a class="dropdown-item" href="<c:url value="/collections/${item.getStrUrl()}"/>">${item.name}</a>
                        </c:forEach>
                    </div>
                </li>

                <!-- Dropdown -->
                <li class="nav-item dropdown"><a
                        class="nav-link dropdown-toggle" href="#" id="navbardrop3"
                        data-toggle="dropdown"> BEAUTY </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item text-uppercase" href="#">Son Môi</a>
                        <a class="dropdown-item text-uppercase" href="#">Phấn Má</a>
                        <a class="dropdown-item text-uppercase" href="#">Phấn Mắt</a>
                        <a class="dropdown-item text-uppercase" href="#">Makeup Set</a>
                    </div>
                </li>

                <!-- Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop4" data-toggle="dropdown"> LADY </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">ÁO</a>
                        <a class="dropdown-item" href="#">JUMPSUIT / VÁY</a>
                        <a class="dropdown-item" href="#">CHÂN VÁY / QUẦN</a>
                    </div>
                </li>

                <!-- Dropdown Dòng nội y-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop5" data-toggle="dropdown"> DÒNG NỘI
                        Y </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">ÁO</a>
                        <a class="dropdown-item" href="#">JUMPSUIT / VÁY</a>
                        <a class="dropdown-item" href="#">CHÂN VÁY / QUẦN</a>
                    </div>
                </li>

                <!-- Dropdown Giảm giá-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop6" data-toggle="dropdown"> GIẢM GIÁ </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">ÁO</a>
                        <a class="dropdown-item" href="#">JUMPSUIT / VÁY</a>
                        <a class="dropdown-item" href="#">CHÂN VÁY / QUẦN</a>
                    </div>
                </li>
            </ul>
        </div>

        <div class="col-md-4 pl-5">
            <form class="border pl-3 pr-3 align-items-center" action="<c:url value="/collections"/> " id="formSearch">
                <div class="input-group-sm d-flex">
                    <%--Input search--%>
                    <input class="form-control-plaintext form-control-sm" type="text" placeholder="Tìm kiếm..." id="inputSearch" name="txt">

                        <%--Input search icon addon--%>
                    <div class="input-group-append">
                        <span id="icon-search-addon" class="input-group-text" style="background: none; outline: none; border: none">
                            <i class="fas fa-search"></i>
                        </span>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>