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

</head>
<body>
<div class="container">

    <div class="jumbotron">
        <h1 class="display-4">Java5 - Lab08!</h1>
        <hr class="my-4">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="<c:url value="/bai01" /> ">Bài 01</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/bai02" />">Bài 02</a>
                    </li>
                </ul>
            </div>
        </nav>

        <content>
            <jsp:include page="${param.view}"/>
        </content>
    </div>
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
