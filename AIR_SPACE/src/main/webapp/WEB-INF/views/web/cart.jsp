<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp"%>

<!DOCTYPE html>

<div id="cart-content" class="mt-2 pb-3 position-relative">

    <%-- Breadcrumb --%>
    <nav aria-label="breadcrumb" style="background-color: #e9ecef;">
        <ol class="breadcrumb container">
            <li class="breadcrumb-item"><a href="<c:url value='/' /> ">Trang chủ</a></li>
            <li class="breadcrumb-item active"><span>Giỏ hàng</span></li>
        </ol>
    </nav>

    <div class="container">
        <c:choose>

            <%-- Not Item in Cart --%>
            <c:when test="${empty myCartList}">
                <div>
                    <p>Không có sản phẩm nào trong giỏ!</p>
                </div>
                <div>
                    <a href="<c:url value="/collections/top-san-pham-ban-chay"/>">
                        <i class="fas fa-share"></i>
                        <span>Tiếp tục mua hàng</span>
                    </a>
                </div>
            </c:when>

            <%-- Item in Cart--%>
            <c:otherwise>
                <div class="row pt-3 pb-5">
                    <hr class="my-4">
                    <form class="col col-md-12" id="form-data-product">

                        <%--Table--%>
                        <div class="row">
                            <table style="width:100%;" id="cart-table" class="table">

                                <thead>
                                <tr>
                                    <th>Ảnh</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Số lượng</th>
                                    <th>Giá tiền</th>
                                    <th></th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach items="${myCartList}" var="item" varStatus="status">
                                    <tr class="line-item" data-value="${status.count}">

                                        <%--Product Image--%>
                                        <td class="item-image">
                                            <img src="${pageContext.request.contextPath}/resources/images/${item.product.imagesList.get(0).name}">
                                        </td>

                                        <%--Product Name & Color/Size--%>
                                        <td class="item-title-name">
                                            <a href="product/${item.product.id}">${item.product.name}</a>
                                            <div>
                                                <span class="text-capitalize">${item.color.name} / ${item.size.name}</span>
                                            </div>
                                        </td>

                                        <%-- Input Quantity --%>
                                        <td class="item-quantity">
                                            <input class="pro-quantity" name="pro_quantity" min="1" type="number"
                                               value="${item.quantity}" data-price="${item.getProduct().getPrice()}">
                                        </td>

                                        <%-- Total Price Each Product --%>
                                        <td class="item-price">
                                            <fmt:formatNumber value="${item.total}" type="currency"/>
                                        </td>

                                        <%-- Btn Delete--%>
                                        <td class="item-delete text-center">
                                            <a href="javascript:void(0) " data-product-id="${item.product.id}"
                                               data-size-id="${item.size.id}" data-color-id="${item.color.id}"
                                               class="delete-item-cart"> <i class="fa fa-times"></i>
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
										<c:set var="total" value="0"/>
										<c:forEach items="${myCartList}" var="item">
                                            <c:set var="total"
                                                   value="${total = total + item.total }"/>
                                        </c:forEach>
										<fmt:formatNumber value="${total}" type="currency"/>
									</span>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col ">
                                        <button type="button" class="btn btn-success mr-4 button-default"
                                                id="update-cart" name="">
                                            <i class="fa fa-caret-left"> </i>
                                            Cập nhật
                                        </button>

                                        <a href="<c:url value="/checkout"/>" class="btn btn-success ml-4 button-default"
                                           id="checkout" name="checkout">
                                            Đặt hàng
                                            <i class="fa fa-caret-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="toast fade hide" role="alert" aria-live="polite" data-delay="1000" aria-atomic="true"
         style="width: 200px;position: fixed; top: 20px; right: 20px;">
        <div class="toast-header">
            <img src="..." class="rounded mr-2" alt="...">
            <strong class="mr-auto">AIR SPACE</strong>
            <small>Message</small>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="toast-body">
            Cập nhật thành công!
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {

        $('.delete-item-cart').click(function () {
            var product = $(this).attr('data-product-id');
            var color = $(this).attr('data-color-id');
            var size = $(this).attr('data-size-id');

            $.ajax({
                url: '${pageContext.request.contextPath}/api/delete-from-cart',
                type: 'POST',
                data: {
                    productID: parseInt(product),
                    colorID: parseInt(color),
                    sizeID: parseInt(size)
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
                url: '${pageContext.request.contextPath}/api/update-cart',
                data: {
                    quantitys: quantitys.toString()
                },
                success: function () {
                    window.location.reload();
                    $('.toast').toast('show');

                }
            })
        })
        
        $('.pro-quantity').change(function () {
        })
    });
</script>
