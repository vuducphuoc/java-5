
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <h1 class="display-4">Student - Form!</h1>
            <hr class="my-4">
            <div class="row">
                <a href="<c:url value="/bai01" />" class="btn btn-success">Bài 01</a>
                <a href="<c:url value="/bai02" />" class="btn btn-success">Bài 02</a>
                <a href="<c:url value="/bai03" />" class="btn btn-success">Bài 03</a>
            </div>
            <div class="row justify-content-center" >
                <div class="col-md-4 border-right" >
                    <form novalidate id="form-student" name="studentForm" action="<c:url value="/" />" method="POST">
                        <div class="form-group" >
                            <label for="name">Họ và tên</label>
                            <input type="text" class="form-control" id="name" required name="name">
                        </div>
                        <div class="form-group">
                            <label for="mark">Điểm trung bình</label>
                            <input type="number" class="form-control" id="mark" min="0" max="10" required name="mark">
                        </div>
                        <div class="form-group">
                            <div class="form-check form-group">
                                <input class="form-check-input major" type="radio" name="major" id="rdo1" value="APP">
                                <label class="form-check-label" for="rdo1">
                                    Ứng dụng phần mềm
                                </label>
                            </div>
                            <div class="form-check form-group">
                                <input class="form-check-input major" type="radio" name="major" id="rdo2" value="WEB">
                                <label class="form-check-label" for="rdo2">
                                    Thiết kế trang web
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="button" value="Thêm" class="btn btn-success" name="action" id="insert">
                            <input type="button" value="Cập nhật" class="btn btn-success" name="action" id="update">
                        </div>
                    </form>
                </div>

                <div class="col-md-8">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Họ Và Tên</th>
                            <th scope="col">Điểm TB</th>
                            <th scope="col">Chuyên Ngành</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:choose>
                            <c:when test="${not empty list}">
                                <c:set var="stt" value="0" />
                                <c:forEach var="item" items="${list}">
                                    <c:set var="stt" value="${stt+1}" />
                                    <tr class="show-data" item-index="${stt-1}" item-name="${item.getName()}" item-mark="${item.getMark()}" item-major="${item.getMajor()}">
                                        <th scope="row">${stt}</th>
                                        <td>${item.getName()}</td>
                                        <td>${item.getMark()}</td>
                                        <td>${item.getMajor()}</td>
                                        <th>
                                            <input type="button" class="btn btn-danger btn-delete" value="Xóa" data-value="${stt-1}">
                                        </th>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="2">
                                        <p>Chưa có dữ liệu!</p>
                                    </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(function () {
            $('#insert').click(function () {
                $.ajax({
                    url: 'api/insert',
                    type: 'POST',
                    data: $('#form-student').serialize(),
                    success: function (value) {
                        window.location.reload();
                        resetForm();
                    }
                })
            });

            $('#update').click(function () {
                var index = $(this).attr('data-index');
                $.ajax({
                    url: 'api/update/'+index,
                    type: 'POST',
                    data: $('#form-student').serialize(),
                    success: function (value) {
                        window.location.reload();
                    }
                })
            });

            $('.btn-delete').click(function () {
                var stt = $(this).attr('data-value');
                $.ajax({
                    url: 'api/delete',
                    type: 'POST',
                    data: {
                        stt: stt
                    },
                    success: function (value) {
                        window.location.reload();
                        resetForm();
                    }
                })
            });

            $('.show-data').click(function () {
                var index = $(this).attr('item-index');
                var name = $(this).attr('item-name');
                var mark = $(this).attr('item-mark');
                var major = $(this).attr('item-major');

                $('#update').attr('data-index', index);
                $('#name').val(name);
                $('#mark').val(mark);

                alert($('#rdo1').val())
                if($('#rdo1').val() == major) {
                    $('#rdo1').attr('checked', 'checked');
                    $('#rdo2').removeAttr('checked');
                } else if ($('#rdo2').val() == major) {
                    $('#rdo2').attr('checked', 'checked');
                    $('#rdo1').removeAttr('checked');
                } else {
                    $('#rdo1').removeAttr('checked');
                    $('#rdo2').removeAttr('checked');
                }

            });

            
        });
        
        function resetForm() {
            $('#name').val('');
            $('#mark').val('');
            $('#rdo1').removeAttr('checked');
            $('#rdo2').removeAttr('checked');
        }

    </script>

</body>
</html>
