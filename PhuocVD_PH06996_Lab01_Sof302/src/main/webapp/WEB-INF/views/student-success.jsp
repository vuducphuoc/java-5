<%--
  Created by IntelliJ IDEA.
  User: phuoc.bleach
  Date: 05/09/19
  Time: 9:45 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student - Success</title>
</head>
<body>
    <div class="container align-items-center">
    <div class="jumbotron">
        <h1 class="display-4">Student - Information!</h1>
        <hr class="my-4">
        <div class="row">
            <ul class="list-group">
                <li class="list-group-item"><b>Họ và tên :</b> ${name}</li>
                <li class="list-group-item"><b>Điểm :</b> ${mark}</li>
                <li class="list-group-item"><b>Chuyên ngành :</b> ${major}</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
