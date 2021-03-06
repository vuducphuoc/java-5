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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>

    <!--Header-->
    <header>
        <tiles:insertAttribute name="header" />
    </header>

    <div class="main">
        <div class="menu-bar">
            <tiles:insertAttribute name="menu" />
        </div>
        <div class="content">
            <tiles:insertAttribute name="body" />
        </div>
    </div>

    <tiles:insertAttribute name="footer" />

    <!-- SCRIPT ============================================================-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/font/fontawesome/js/all.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wow.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.bundle.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom.js"></script>
</body>
</html>
