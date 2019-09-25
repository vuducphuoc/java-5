
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/taglib.jsp"%>
<html>
<head>
    <title>Bài 03 - Lab 03</title>
    <base href="${pageContext.servletContext.contextPath}">
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Student - Form!</h1>
        <hr class="my-4">
        <div class="row justify-content-center">
            <div class="col-md-4 border-right">
                <form:form id="form-student" name="studentForm" modelAttribute="student" action="#">
                    <div class="form-group">
                        <label for="name">Họ và tên</label>
                        <form:input class="form-control" path="name" />
                    </div>
                    <div class="form-group">
                        <label for="mark">Điểm trung bình</label>
                        <form:input class="form-control" path="mark" />
                        <form:errors path="mark" />
                    </div>
                    <div class="form-group ">
                        <form:radiobuttons class="" path="major" items="${majors}"
                        itemValue="id" itemLabel="name" />
                    </div>
                    <div class="form-group">
                        <input type="button" value="Cập nhật" class="btn btn-success" name="action" id="update">
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
