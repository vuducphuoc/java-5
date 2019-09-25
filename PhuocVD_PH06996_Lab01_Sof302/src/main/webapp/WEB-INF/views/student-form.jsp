<%--
  Created by IntelliJ IDEA.
  User: phuoc.bleach
  Date: 05/09/19
  Time: 9:43 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Form</title>
</head>
<body>
    <div class="container align-items-center">
        <div class="jumbotron">
            <h1 class="display-4">Student - Form!</h1>
            <hr class="my-4">
            <div class="row pl-5">
                <form action="<c:url value="/success" />" method="post" style="width: 400px" class="needs-validation" novalidate>
                    <div class="form-group">
                        <label for="name">Họ và tên</label>
                        <input type="text" class="form-control" id="name" placeholder="" required name="name">
                        <div class="invalid-feedback">
                            Vui lòng nhập họ tên!
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mark">Điểm trung bình</label>
                        <input type="text" class="form-control" id="mark" placeholder="" pattern="^[0-9]+$" required name="mark">
                        <div class="invalid-feedback">
                            Vui lòng nhập đúng định dạng số!
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Chuyên ngành</label>
                        <div class="form-check form-group">
                            <input class="form-check-input" type="radio" name="major" id="rdo1" value="APP" checked>
                            <label class="form-check-label" for="rdo1">
                                Ứng dụng phần mềm
                            </label>
                        </div>
                        <div class="form-check form-group">
                            <input class="form-check-input" type="radio" name="major" id="rdo2" value="WEB">
                            <label class="form-check-label" for="rdo2">
                                Thiết kế trang web
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Save" class="btn btn-success">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
            'use strict';
            window.addEventListener('load', function() {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</body>
</html>