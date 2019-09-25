<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Layout</title>
    <link rel="stylesheet" href="resources/Bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="resources/Bootstrap/fontawesome/fontawesome.css">
    <link rel="stylesheet" href="resources/Bootstrap/fontstyle/roboto.css">
    <link rel="stylesheet" href="resources/MyStyle/style.css">
    <link rel="stylesheet" href="resources/Bootstrap/sweetalert/dist/sweetalert2.min.css">
    <script type="text/javascript" src="resources/Bootstrap/jquery/jquery.min.js"></script>
    <base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
<div class="container">
    <header>
        <h1>Shopping Mall</h1>
    </header>

    <%--Narbar--%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <%@ include file="admin/admin-menu.jsp"%>
    </nav>

    <%--Content--%>
    <article>
        <jsp:include page="${param.view}"/>
    </article>

    <%--Side Bar Right--%>
    <aside>CONTROL PANEL</aside>
    <footer>FOOTER</footer>
</div>

<!-- SCRIPT ============================================================-->
<script type="text/javascript" src="resources/Bootstrap/fontawesome/fontawesome.js"></script>
<script type="text/javascript" src="resources/Bootstrap/sweetalert/dist/sweetalert2.all.min.js"></script>
<script type="text/javascript" src="resources/Bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/Bootstrap/js/wow.min.js"></script>
<script type="text/javascript" src="resources/Bootstrap/js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="resources/MyStyle/custom.js"></script>
</body>
</html>
