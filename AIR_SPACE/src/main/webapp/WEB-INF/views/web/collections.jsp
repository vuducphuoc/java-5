<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp" %>
<!DOCTYPE html>

<div class="col-md-9">
    <%-- // Product--%>
    <div class="row d-flex ml-2">

        <c:forEach items="${productListItem}" var="product">
            <c:if test="${product.imagesList.size() > 0}">
                <div class="cart-product pro-loop col-md-3 p-0">
                        <%--Image--%>
                    <div class="product-image shadow-sm rounded">
                        <a href="<c:url value="/product/${product.id}" /> ">
                            <img src="${pageContext.request.contextPath}/resources/images/${product.imagesList.get(0).name}"
                                 alt="${product.imagesList.get(0).name}" class="img-fluid first-image">
                            <img src="${pageContext.request.contextPath}/resources/images/${product.imagesList.get(1).name}"
                                 alt="${product.imagesList.get(1).name}" class="img-fluid second-image">
                        </a>

                        <div class="actions d-flex justify-content-around">
                            <div class="actions-items col-md-2 d-flex justify-content-center align-items-center">
                                <a href="javascript:void(0);">
                                    <i class="far fa-heart"></i>
                                </a>
                            </div>

                            <div class="actions-items col-md-2 d-flex justify-content-center align-items-center add-to-cart"
                                 data-value="${product.id}">
                                <a href="javascript:void(0);">
                                    <i class="fas fa-shopping-bag"></i>
                                </a>
                            </div>

                            <div class="actions-items col-md-2 d-flex justify-content-center align-items-center">
                                <a href="javascript:void(0);">
                                    <i class="far fa-clone"></i>
                                </a>
                            </div>

                            <div class="actions-items col-md-2 d-flex justify-content-center align-items-center">
                                <a href="javascript:void(0);">
                                    <i class="fas fa-eye"></i>
                                </a>
                            </div>
                        </div>
                    </div>

                        <%--Name--%>
                    <div class="product-name text-center" name="productName">
                        <a href="<c:url value="/product/${product.id}" />" class="redirect-product">
                                ${product.name}
                        </a>
                    </div>

                    <div class="product-price text-center" name="productPrice">
                        <fmt:formatNumber value="${product.price}" type="currency"/>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div> <%--End Produt // --%>

    <%-- // Message Toast--%>
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
            Thêm thành công!
        </div>
    </div>
</div>

<script>

    $(function () {
        // Thêm giỏ hàng
        $('.add-to-cart').click(function () {
            var productID = $(this).attr('data-value');
            console.log(productID)
            $.ajax({
                url: '${pageContext.request.contextPath}/api/add-to-cart',
                type: 'POST',
                data: {
                    productID: parseInt(productID)
                },
                success: function (value) {
                    $('#cart-quantity').text(parseInt(value));
                    $('.toast').toast('show');
                }
            })
        })

    })

</script>
