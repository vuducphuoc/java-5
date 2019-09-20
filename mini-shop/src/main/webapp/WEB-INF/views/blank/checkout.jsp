<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thanh toán hóa đơn</title>
    <link rel="stylesheet" href="resources/MyStyle/checkouts.css">
</head>
<body>

<div class="container pt-5">
    <div class="row">
        <div class="col col-md-6 main">
            <div class="main-header">
                <a href="<c:url value="/"/>" class="logo">
                    <h1 class="logo-text">AIR SPACE</h1>
                </a>
                <ul class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="<c:url value="/cart"/>">Giỏ hàng</a>
                    </li>
                    <li class="breadcrumb-item breadcrumb-item-current">
                        Thông tin giao hàng
                    </li>
                    <li class="breadcrumb-item ">
                        Phương thức thanh toán
                    </li>
                </ul>
            </div>

            <div class="main-content">
                <section>
                    <div class="section-header">
                        <h2 class="section-title">Thông tin giao hàng</h2>
                    </div>

                    <div class="section-content">

                        <%--Customer Information--%>
                        <div class="customer-information">
                            <%--Avatar--%>
                            <div class="customer-information-avatar-wrapper">
                                <div class="customer-information-avatar gravatar"></div>
                            </div>

                            <div class="customer-information-paragraph">
                                ${accountLogin.getName()} (${accountLogin.getEmail()})
                                <br>
                                <a href="<c:url value="/login" /> " class="btn-logout">Đăng xuất</a>
                            </div>
                        </div>

                        <div class="form-customer-information">
                            <form action="" id="customer-form">
                                <%--Name--%>
                                <div class="form-group">
                                    <label class="label-inform" for="customer-name">Họ và tên</label>
                                    <input placeholder="Họ và tên" class="form-control" type="text"
                                           id="customer-name" name="name" value="">
                                </div>

                                <%--Phone--%>
                                <div class="form-group">
                                    <label class="label-inform" for="customer-phone">Số điện thoại</label>
                                    <input placeholder="Số điện thoại" class="form-control" size="30" maxlength="10"
                                           id="customer-phone" name="phone" value="">
                                </div>

                                <%--Address--%>
                                <div class="form-group">
                                    <label class="label-inform" for="customer-address">Địa chỉ</label>
                                    <input placeholder="Địa chỉ" class="form-control" type="text"
                                           id="customer-address" name="address" value="">
                                </div>

                                <div class="form-group row">
                                    <div class="col col-md-6 m-auto">
                                        <a class="step-footer-previous-link" href="<c:url value="/cart"/>">
                                            <svg class="previous-link-icon icon-chevron icon"
                                                 xmlns="http://www.w3.org/2000/svg"
                                                 width="6.7" height="11.3" viewBox="0 0 6.7 11.3">
                                                <path d="M6.7 1.1l-1-1.1-4.6 4.6-1.1 1.1 1.1 1 4.6 4.6 1-1-4.6-4.6z"></path>
                                            </svg>
                                            Giỏ hàng
                                        </a>
                                    </div>

                                    <div class="col col-md-6 text-right">
                                        <button type="submit" class="btn button-default btn-checkout">
                                            <span class="btn-content">Xác nhận đặt hàng!</span>
                                            <i class="btn-spinner icon icon-button-spinner"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
            <div class="main-footer">
            </div>
        </div>

        <div class="col col-md-6 sidebar ">
            <section class="p-4">
                <div class="row">
                    <table class="product-table table table-borderless">
                        <thead class="d-none">
                            <tr>
                                <th scope="col"><span class="d-none">Hình ảnh</span></th>
                                <th scope="col"><span class="d-none">Mô tả</span></th>
                                <th scope="col"><span class="d-none">Giá</span></th>
                            </tr>
                        </thead>

                        <tbody>
                        <c:set var="allTotalPrice" value="0"/>
                        <c:forEach var="item" items="${listItemCart}">
                            <c:set var="allTotalPrice"
                                   value="${allTotalPrice + item.getProduct().getPrice()* item.getQuantity()}"/>
                            <tr class="product" data-product-id="${item.getIdProduct()}">
                                <td class="product-image">
                                    <div class="product-thumbnail">
                                        <div class="product-thumbnail-wrapper">
                                            <img class="product-thumbnail-image"
                                                 alt="${item.getProduct().getName()}"
                                                 src="<c:url value='resources/Image/Product/${item.getProduct().getImage()[0]}'/>">
                                        </div>
                                        <span class="product-thumbnail-quantity" aria-hidden="true">
                                                ${item.getQuantity()}
                                        </span>
                                    </div>
                                </td>

                                <td class="product-description m-auto">
                                    <span class="product-description-name order-summary-emphasis">
                                            ${item.getProduct().getName()}
                                    </span>

                                    <span class="product-description-variant order-summary-small-text">
                                                ${item.getColor().getName()} /  ${item.getSize().getName()}
                                    </span>
                                </td>
                                <td class="product-price m-auto">
                                    <span class="order-summary-emphasis">
                                        <fmt:formatNumber
                                                value="${item.getProduct().getPrice()* item.getQuantity()}"
                                                type="currency"/>
                                    </span>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="form-group row discount">
                    <div class="col-sm-8">
                        <input type="text" placeholder="Mã giảm giá" class="form-control" value="">
                    </div>
                    <div class="col-sm-4">
                        <button class="btn button-default btn-apply-discout">
                            Sử dụng
                        </button>
                    </div>
                </div>

                <div class="row table-price">
                    <table class="table">
                        <thead class="d-none">
                        <tr>
                            <th scope="col"><span class="d-none">Mô tả</span></th>
                            <th scope="col"><span class="d-none">Giá</span></th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr class="total-line total-line-subtotal">
                            <td class="total-line-name">Tạm tính</td>
                            <td class="total-line-price text-center">
                                <span class="order-summary-emphasis">
                                    <fmt:formatNumber value="${allTotalPrice}" type="currency"/>
                                </span>
                            </td>
                        </tr>

                        <tr class="total-line total-line-shipping">
                            <td class="total-line-name">Phí vận chuyển</td>
                            <td class="total-line-price text-center">
                                <span class="order-summary-emphasis">—</span>
                            </td>
                        </tr>
                        </tbody>

                        <tfoot class="total-line-table-footer">
                        <tr>
                            <td class="total-line-name payment-due-label">
                                <span class="payment-due-label-total">Tổng cộng</span>
                            </td>

                            <td class="total-line-name payment-due text-center">
                                <span class="payment-due-currency">VND</span>
                                <span class="payment-due-price">
                                    <fmt:formatNumber value="${allTotalPrice}" type="currency"/>
                                </span>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </section>
        </div>
    </div>
</div>

<script>
    $(function () {
        $('.btn-checkout').click(function () {
            $.ajax({
                type: 'POST',
                url: 'api/checkout',
                data: $('#customer-form').serialize(),
                success: function (value) {
                    alert(value)
                }
            })
        })
    })
</script>
</body>
</html>