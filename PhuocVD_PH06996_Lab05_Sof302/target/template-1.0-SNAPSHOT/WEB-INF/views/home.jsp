<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<body>

    <div class="container">
        <div class="jumbotron">
            <h1 class="display-4 text-uppercase">Java 5 - Lab 05</h1>
            <hr class="my-4">
            <div class="row">
                <a href="<c:url value="/bai01" />" class="btn btn-success">Bài 01</a>
                <a href="<c:url value="/bai02" />" class="btn btn-success">Bài 02</a>
                <a href="<c:url value="/bai03" />" class="btn btn-success">Bài 03</a>
            </div>
        </div>
    </div>

</body>
</html>
