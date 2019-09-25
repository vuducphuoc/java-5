<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<html>
<head>
    <title>Bài 02</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-4 text-uppercase">Nộp đơn xin việc</h1>
        <hr class="my-4">

        <c:if test="${not empty message}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    ${message}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <div class="row">
            <div class="col-md-6">
                <form action="<c:url value="/apply"/>" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="fullname">Họ và tên ứng viên</label>
                        <input class="form-control" name="fullname" id="fullname" value="">
                    </div>

                    <div class="form-group">
                        <label for="photo">Hình ảnh</label>
                        <input type="file" class="form-control-file" name="photo" id="photo" value="">
                    </div>

                    <div class="form-group">
                        <label for="cv">Hồ sơ xin việc</label>
                        <input type="file" class="form-control-file" name="cv" id="cv" value="">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-success">Nộp</button>
                    </div>
                </form>
            </div>
            <div class="col-md-6">
                <div class="card" style="width: 18rem;">
                    <img src="resources/${photo_name}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${param.fullname}</h5>
                        <p class="card-text">File Name: ${cv_name}</p>
                        <p class="card-text">File Type: ${cv_type}</p>
                        <p class="card-text">File Size: ${cv_size}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
