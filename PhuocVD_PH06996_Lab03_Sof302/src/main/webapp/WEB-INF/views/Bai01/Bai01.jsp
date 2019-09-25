<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc.bleach
  Date: 09/09/19
  Time: 10:09 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bài 01 - Lab03</title>
</head>
<body>
    <div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Student - Form!</h1>
        <hr class="my-4">
        <div class="row justify-content-center" >
            <div class="col-md-4 border-right" >
                <form novalidate id="form-student" name="studentForm" action="<c:url value="/" />" method="POST">
                    <div class="form-group" >
                        <label for="name">Họ và tên</label>
                        <input type="text" class="form-control" id="name" required name="name" value="${student.name}">
                    </div>
                    <div class="form-group">
                        <label for="mark">Điểm trung bình</label>
                        <input type="number" class="form-control" id="mark" min="0" max="10" required name="mark" value="${student.mark}">
                    </div>
                    <div class="form-group">
                        <div class="form-check form-group">
                            <input class="form-check-input major" type="radio" name="major" id="rdo1" value="APP" ${student.major=='APP'?'checked':''}>
                            <label class="form-check-label" for="rdo1">
                                Ứng dụng phần mềm
                            </label>
                        </div>
                        <div class="form-check form-group">
                            <input class="form-check-input major" type="radio" name="major" id="rdo2" value="WEB" ${student.major=='WEB'?'checked':''}>
                            <label class="form-check-label" for="rdo2">
                                Thiết kế trang web
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="button" value="Cập nhật" class="btn btn-success" name="action" id="update">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
