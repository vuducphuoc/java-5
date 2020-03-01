<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/taglib.jsp" %>

<div class="col-md-9">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="<c:url value="/account/change-password"/> " method="post" id="create-customer"
                  class="needs-validation border shadow rounded p-3" novalidate>
                <div class="form-group text-center">
                    <h3>Đổi mật khẩu</h3>
                </div>

                <c:if test="${not empty alertMessage}">
                    <div class="alert ${alertType} alert-dismissible fade show" role="alert">
                            ${alertMessage}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span class="h5" aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>

                <div class="form-group">
                    <input type="password" class="form-control" id="old-password" name="oldPassword" placeholder="Mật khẩu cũ" value="" required>
                    <div class="invalid-feedback">
                        Vui lòng nhập mật khẩu cũ !
                    </div>
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="newPassword" placeholder="Mật khẩu mới" value="" required>
                    <div class="invalid-feedback">
                        Vui lòng nhập mật khẩu mới!
                    </div>
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="repassword" name="repassword" placeholder="Xác nhận mật khẩu"
                           value="" required >
                    <div class="invalid-feedback">
                        Vui lòng xác nhận mật khẩu !
                    </div>
                </div>

                <div class="form-group pt-2">
                    <input type="submit" class="col-12 btn btn-success" id="btn-change-password" value="Lưu thay đổi" >
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {

        $('#password').change(function () {
            $('#repassword').attr('pattern', $(this).val());
            $('#repassword').closest('.form-group').find('.invalid-feedback').text('Mật khẩu không trùng khớp');
        })
    });

</script>