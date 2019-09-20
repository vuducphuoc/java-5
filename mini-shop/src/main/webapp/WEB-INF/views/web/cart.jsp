<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Giỏ hàng</title>

</head>
<body>

	<div id="cart-content" class="mt-2">
		<div class="clearfix breadcrumb-arrows">
			<div class="row">
				<div class="col col-md-12">
					<ol class="breadcrumb breadcrumb-arrows">
						<li><a href="<c:url value='/' /> ">Trang chủ</a></li>
						<li class="active"> <span> / Giỏ hàng</span></li>
					</ol>
				</div>
			</div>
			<div class="container">
				<div class="row pt-3 pb-5">
					<hr class="my-4">
					<form class="col col-md-12" id="form-data-product">
						<div class="row">
							<table style="width:100%;" id="cart-table" class="table">
							<tbody>
								<tr>
									<th>Ảnh</th>
									<th>Tên sản phẩm</th>
									<th>Số lượng</th>
									<th>Giá tiền</th>
									<th></th>
								</tr>

								<c:forEach items="${listItemCart}" var="item">
									<tr class="line-item">
										<td class="item-image"><img src="<c:url value='resources/Image/Product/${item.getProduct().getImage()[0]}'/>"></td>
										<td class="item-title-name">
											<a href="product/${item.getProduct().getId()}">${item.getProduct().getName()}</a>
											<div>
												<span class="text-capitalize"> ${item.getColor().getName()} /  ${item.getSize().getName()}</span>
											</div>
										</td>
										<td class="item-quantity">
											<input class="pro-quantity" name="pro_quantity" min="1" type="number" value="${item.getQuantity()}" data-price="${item.getProduct().getPrice()}">
										</td>

										<td class="item-price">
											<fmt:formatNumber value ="${item.getTotalPrice()}" type ="currency"/>
										</td>
										<td class="item-delete text-center">
											<a href="javascript:void(0) " data-product="${item.getIdProduct()}" data-size="${item.getIdSize()}"
											   data-color="${item.getIdColor()}" class="delete-item-cart">
												<i class="fa fa-times"></i>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="modal-note row">
									<textarea placeholder="Viết ghi chú" id="note" name="note" rows="5"></textarea>
								</div>

								<div class="row">
									<div class="comeback">
										<a href="<c:url value='/' />">
											<i class="fa fa-caret-left mr-10"></i>
											Tiếp tục mua hàng
										</a>
									</div>
								</div>
							</div>

							<div class="col-md-6 text-center">
								<div class="row justify-content-center mb-5">
									<div class="total-price-modal">
										Tổng cộng :
										<span class="item-total">
											<c:set var="total" value="0" />
											<c:forEach items="${listItemCart}" var="item">
												<c:set var="total" value="${total = total + (item.getProduct().getPrice() * item.getQuantity()) }" />
											</c:forEach>
											<fmt:formatNumber value ="${total}" type ="currency"/>
										</span>
									</div>
								</div>
								<div class="row">
									<div class="col ">
										<button type="button" class="btn btn-success mr-4 button-default" id="update-cart"  name="">
											<i class="fa fa-caret-left"> </i>
											Cập nhật
										</button>

										<a href="<c:url value="/checkout"/>" class="btn btn-success ml-4 button-default" id="checkout"  name="checkout">
											Đặt hàng
											<i class="fa fa-caret-right"></i>
										</a>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
        $(document).ready(function () {
            $('.pro-quantity').change(function () {
            })

            $('.delete-item-cart').click(function () {
                var product = $(this).attr('data-product');
                var color = $(this).attr('data-color');
                var size = $(this).attr('data-size');
                $.ajax({
                    url: 'api/delete-from-cart',
                    type: 'POST',
                    data: {
                        idProduct: product,
						idColor: color,
						idSize: size
                    },
                    success: function (value) {
                        $('#cart-quantity').text(parseInt(value));
                        window.location.reload();
                    }
                })
            })

            $('#update-cart').click(function () {
                var quantitys = [];
                $('.pro-quantity').each(function (index) {
                    quantitys[index] = $(this).val();
                })

				$.ajax({
					type: 'POST',
					url: 'api/update-to-cart',
					data: {
					    quantitys : quantitys.toString()
					},
					success: function () {

                    }
				})
            })
        });
	</script>

</body>
</html>