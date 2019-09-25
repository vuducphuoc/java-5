<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Bài 01</title>
</head>
<body>
<div class="row">
    <div class="col-md-6">
        <h1>Quản Lý Sinh Viên 1</h1>
        <c:if test="${not empty message}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <p>${message}</p>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <form:form modelAttribute="student" action="#">
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
                <form:radiobuttons path="major" items="${majors}"
                                   itemValue="id" itemLabel="name" />
            </div>
            <div class="form-group">
                <input type="button" value="Cập nhật" class="btn btn-success" name="action" id="update">
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
