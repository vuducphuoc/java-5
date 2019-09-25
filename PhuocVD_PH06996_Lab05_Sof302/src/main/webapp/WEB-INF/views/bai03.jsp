
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<html>
<head>
    <title>Bài 03</title>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <h1 class="display-4 text-uppercase">Bài 03 - Lab 05</h1>
            <hr class="my-4">

            <div class="row">
                <div class="col-md-6">
                    <form action="<c:url value="/send"/>" method="POST">
                        <c:if test="${not empty alertMessage}" >
                            <div class="alert alert-${alertType} alert-dismissible fade show" role="alert">
                                    ${alertMessage}
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:if>

                        <div class="form-group">
                            <label for="from">From</label>
                            <input type="text" class="form-control" name="from" id="from" value="">
                        </div>

                        <div class="form-group">
                            <label for="to">To</label>
                            <input type="text" class="form-control" name="to" id="to" value="">
                        </div>

                        <div class="form-group">
                            <label for="subject">Subject</label>
                            <input type="text" class="form-control" name="subject" id="subject" value="">
                        </div>

                        <div class="form-group">
                            <label for="body">Message</label>
                            <textarea class="form-control" id="body" name="body" rows="3"></textarea>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-success">Gửi</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
