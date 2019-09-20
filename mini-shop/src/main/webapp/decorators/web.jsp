<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/Bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/Bootstrap/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="resources/Bootstrap/fontstyle/roboto.css">
    <link rel="stylesheet" href="resources/MyStyle/style.css">
    <script type="text/javascript" src="resources/Bootstrap/jquery/jquery.min.js"></script>
    <dec:head />
</head>
<body>

    <header>
        <%@ include file="/common/web/header.jsp" %>
        <%@ include file="/common/web/menu.jsp" %>
    </header>

<div class="content">
    <dec:body/>
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
