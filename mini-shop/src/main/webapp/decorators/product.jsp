<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/Bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/Bootstrap/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="resources/Bootstrap/fontstyle/roboto.css">
    <link rel="stylesheet" href="resources/MyStyle/style.css">
    <script type="text/javascript" src="resources/Bootstrap/jquery/jquery.min.js"></script>
    <dec:title/>
    <dec:head/>
</head>
<body>

<header>
    <%@ include file="/common/web/header.jsp" %>
    <%@ include file="/common/web/menu.jsp" %>
</header>

<div class="content clearfix container pt-5 pb-5">
    <div class="">
        <div id="product" class="content-pages" data-sticky_parent="">
            <%--ROW PRODUCT--%>
            <div class="row">
                <div class="col-md-3" data-sticky_column ="">
                    <%--Side bar--%>
                    <%@ include file="/common/web/category.jsp" %>
                </div>

                <!-- Chi tiết sản phẩm-->
                <div class="col-md-9" data-sticky_column="">
                    <dec:body/>
                </div>
            </div>
        </div>
    </div>


</div>

<footer>
    <%@ include file="/common/web/footer.jsp" %>
</footer>

<!-- SCRIPT ============================================================-->
<script type="text/javascript" src="resources/Bootstrap/fontawesome/js/all.min.js"></script>
<script type="text/javascript" src="resources/Bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/Bootstrap/js/wow.min.js"></script>
<script type="text/javascript" src="resources/Bootstrap/js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="resources/MyStyle/custom.js"></script>
</body>
</html>
