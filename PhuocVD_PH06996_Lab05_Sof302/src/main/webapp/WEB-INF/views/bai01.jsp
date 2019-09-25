<%--
  Created by IntelliJ IDEA.
  User: phuoc.bleach
  Date: 10/09/19
  Time: 2:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Bài 01</title>
</head>
<body>
    <div class="container">
        <form>
            <div class="form-group">
                <label for="username">Username</label>
                <input class="form-control" name="username" id="username" value="${user.username}">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input class="form-control" name="password" id="password" value="${user.password}">
            </div>
            <div class="form-group">
                <button>Login</button>
            </div>
        </form>
    </div>
</body>
</html>
