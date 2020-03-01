<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title> <tiles:getAsString name="title" /> </title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font/fontawesome/css/fontawesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font/roboto.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/angular-1.6.9/angular.js"></script>


    <style>
        #sidebar {
            background: #f1f2f6;
        }

        #sidebar .sidebar-content .sidebar-brand > a {
            font-size: 20px;
        }
    </style>
</head>

<body>
    <div class="page-wrapper chiller-theme toggled">
        <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
            <i class="fas fa-bars"></i>
        </a>

        <nav id="sidebar" class="sidebar-wrapper">
            <div class="sidebar-content">
                <div class="sidebar-brand">
                    <a href="<c:url value="/"/> ">AIR-SPACE</a>
                    <div id="close-sidebar" class="pr-3 pl-3">
                        <i class="fas fa-times"></i>
                    </div>
                </div>

                <div class="sidebar-header">
                    <div class="user-pic">
                        <img class="img-responsive img-rounded"
                             src="${pageContext.request.contextPath}/resources/images/user.jpg"
                             alt="User picture">
                    </div>
                    <div class="user-info">
                      <span class="user-name">
                          <strong>${userLogin.name}</strong>
                      </span>
                        <span class="user-role">Administrator</span>
                        <span class="user-status" style="color: #28a745">
                            <i class="fa fa-circle"></i>
                            <span style="color: #000;">Online</span>
                        </span>
                    </div>
                </div>

                <div class="sidebar-menu">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item" style="font-size: 24px;">
                            Menu
                        </li>

                        <li class="list-group-item">
                            <a href="<c:url value="/admin/home" /> ">
                                <i class="fa fa-tachometer-alt"></i>
                                <span>Trang chủ</span>
                            </a>
                        </li>

                        <li class="list-group-item">
                            <a href="<c:url value="/admin/tai-khoan" /> ">
                                <i class="fas fa-address-card"></i>
                                <span>Quản lý Tài khoản</span>
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a href="<c:url value="/admin/san-pham" />">
                                <i class="far fa-gem"></i>
                                <span>Quản lý Sản phẩm</span>
                            </a>
                        </li>

                        <li class="list-group-item">
                            <a href="<c:url value="/admin/san-pham-chi-tiet" />">
                                <i class="fas fa-info"></i>
                                <span>Sản phẩm chi tiết</span>
                            </a>
                        </li>

                        <li class="list-group-item">
                            <a href="<c:url value="/admin/hoa-don" />">
                                <i class="far fa-money-bill-alt"></i>
                                <span>Danh sách Hóa đơn</span>
                            </a>
                        </li>
                    </ul>
                </div>
                <!-- sidebar-menu  -->
            </div>
            <!-- sidebar-content  -->
            <div class="sidebar-footer">
                <a href="#">
                    <i class="fa fa-bell"></i>
                    <span class="badge badge-pill badge-warning notification">3</span>
                </a>
                <a href="#">
                    <i class="fa fa-envelope"></i>
                    <span class="badge badge-pill badge-success notification">7</span>
                </a>
                <a href="#">
                    <i class="fa fa-cog"></i>
                    <span class="badge-sonar"></span>
                </a>
                <a href="<c:url value="/logout" />">
                    <i class="fa fa-power-off"></i>
                </a>
            </div>
        </nav>

        <div class="page-content">
            <tiles:insertAttribute name="body" />
        </div>
    </div>

    <tiles:insertAttribute name="footer" />

    <script>
        jQuery(function ($) {

            $(".sidebar-dropdown > a").click(function() {
                $(".sidebar-submenu").slideUp(200);
                if (
                    $(this)
                        .parent()
                        .hasClass("active")
                ) {
                    $(".sidebar-dropdown").removeClass("active");
                    $(this)
                        .parent()
                        .removeClass("active");
                } else {
                    $(".sidebar-dropdown").removeClass("active");
                    $(this)
                        .next(".sidebar-submenu")
                        .slideDown(200);
                    $(this)
                        .parent()
                        .addClass("active");
                }
            });

            $("#close-sidebar").click(function() {
                $(".page-wrapper").removeClass("toggled");
            });

            $("#show-sidebar").click(function() {
                $(".page-wrapper").addClass("toggled");
            });
        });
    </script>

    <!-- SCRIPT ============================================================-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/font/fontawesome/js/all.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wow.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.bundle.js"></script>
</body>

</html>

