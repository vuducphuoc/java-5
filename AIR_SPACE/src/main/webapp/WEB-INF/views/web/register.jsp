<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>

<%-- Breadcrumb --%>
<div class="pt-3">
	<nav aria-label="breadcrumb" style="background-color: #e9ecef;">
		<ol class="breadcrumb container">
			<li class="breadcrumb-item"><a href="<c:url value='/' /> ">Trang chủ</a></li>
			<li class="breadcrumb-item active"><span>Đăng ký</span></li>
		</ol>
	</nav>
</div>

<div id="register-content" class="clearfix container pt-4 pb-5">
	<div class="row">
		<div class="col col-md-12">
			<div class="row justify-content-center">
				<div class="userbox loginbox col-md-5 border shadow rounded pt-5 pb-4">
					<h1 class="text-center text-upercase">Tạo tài khoản</h1>
					<p class="text-center"> Chào mừng bạn đến với AIR SPACE Việt Nam!</p>
<%--					<c:if test="${not empty alertMessage}">--%>
						<div class="alert ${alertType} alert-dismissible fade show ${not empty alertMessage ? '' : 'd-none'} " role="alert">
								${alertMessage}
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								<span class="h5" aria-hidden="true">&times;</span>
							</button>
						</div>
<%--					</c:if>--%>

					<p>Vui lòng điền thông tin vào các mục dưới đây:</p>

					<form action="<c:url value="/register"/> " method="post" id="create-customer"
						class="needs-validation" novalidate>
						<div class="form-group">
							<input type="text" class="form-control" name="name" id="name" placeholder="Họ và tên" value="" required>
							<div class="invalid-feedback">
								Vui lòng nhập họ tên!
							</div>
						</div>

						<div class="form-group">
							<input type="email" class="form-control" name="email" id="email" placeholder="Email" value="" required>
							<div class="invalid-feedback">
								Vui lòng nhập một email!
							</div>
						</div>

						<div class="form-group">
							<input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu" value="" required>
							<div class="invalid-feedback">
								Vui lòng nhập mật khẩu !
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

		$('#password').change(function () {
			$('#repassword').attr('pattern', $(this).val());
			$('#repassword').closest('.form-group').find('.invalid-feedback').text('Mật khẩu không trùng khớp');
		})

	});

</script>

