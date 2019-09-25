<%--
  Created by IntelliJ IDEA.
  User: phuoc.bleach
  Date: 05/09/19
  Time: 9:47 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Spring MVC</title>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <h1 class="display-4">Wellcome to Spring MVC!</h1>
            <hr class="my-4">
            <a class="btn btn-primary btn-lg" href="<c:url value="/student"/> " role="button">Student-Form</a>
        </div>
    </div>
</body>
</html>
