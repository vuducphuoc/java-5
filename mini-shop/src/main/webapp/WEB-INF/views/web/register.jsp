<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Đăng ký</title>
</head>
<body>

	<!-- Header -->
	<div id="register-content" class="clearfix container">
		<div class="row">
			<div class="col col-md-12 ">
				<div class="row justify-content-center">
					<div class="userbox loginbox col-md-5 border pt-5 mt-5 mb-5">
						<h1 class="text-center text-upercase">Tạo tài khoản</h1>
						<p class="text-center"> Chào mừng bạn đến với AIR SPACE Việt Nam!</p>
						<c:if test="${not empty alertMessage}">
							<div class="alert ${alertType} alert-dismissible fade show" role="alert">
									${alertMessage}
								<button type="button" class="close" data-dismiss="alert" aria-label="Close">
									<span class="h5" aria-hidden="true">&times;</span>
								</button>
							</div>
						</c:if>

						<p>Vui lòng điền thông tin vào các mục dưới đây:</p>

						<form action="<c:url value="/register"/> " method="post" id="create-customer">
							<div class="form-group">
								<input type="text" class="form-control" name="name" id="name" placeholder="Họ và tên" value="">
							</div>

							<div class="form-group">
								<input type="email" class="form-control" name="email" id="email" placeholder="Email" value="">
							</div>

							<div class="form-group">
								<input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu" value="">
							</div>

							<div class="form-group">
								<input type="password" class="form-control" id="repassword" name="repassword" placeholder="Xác nhận mật khẩu" value="">
							</div>

							<div class="form-group">
								<input type="text" class="form-control" name="phone" id="phone" placeholder="Số điện thoại" value="">
							</div>

							<div class="form-group pt-2">
								<input type="submit" class="col-12 btn btn-success" id="btn-register" value="ĐĂNG KÝ" >
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
        $(function () {
			$('#create-customer').validate({
				rules: {
				    name: {
				        required: true
					},
				    email:  {
				        required: true,
						email: true
					},
					password: {
                        required: true,
						minlength: 6
					},
					repassword: {
                        required: true,
						equalTo: '#password'
					},
					phone: {
                        required: true,
						number: true,
                        minlength: 10,
                        maxlength: 10
					}
				},
				messages: {
				    name: {
				        required: 'Vui lòng nhập họ tên',
					},
					email: {
				        required: 'Vui lòng nhập email',
						email: 'Vui lòng nhập đúng định dạng email'
					},
					password: {
                        required: 'Vui lòng nhập mật khẩu',
                        minlength: 'Vui lòng nhập mật khẩu, ít nhất 6 ký tự'
					},
                    repassword: {
                        required: 'Vui lòng xác nhận mật khẩu',
						equalTo: 'Mật khẩu không khớp'
					},
					phone: {
                        required: 'Vui lòng nhập số điện thoại',
						minlength: 'Vui lòng nhập đúng định dạng số điện thoại',
						maxlength: 'Vui lòng nhập đúng định dạng số điện thoại',
						number: 'Vui lòng nhập đúng định dạng số điện thoại'
					}
				},
                errorClass: "is-invalid",
                errorPlacement: function (error, element) {
                    error.addClass('text-danger');
                    error.insertAfter(element);
                },
				submitHandler: function (form) {
					form.submit();
                }
			})
        });
	</script>

</body>
</html>