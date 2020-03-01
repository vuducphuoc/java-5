<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp" %>

<!DOCTYPE html>

<div class="position-relative">

    <div id="slideshow" class="carousel slide" data-ride="carousel">

        <ul class="carousel-indicators">
            <li data-target="#slideshow" data-slide-to="0" class="active"></li>
            <li data-target="#slideshow" data-slide-to="1"></li>
            <li data-target="#slideshow" data-slide-to="2"></li>
            <li data-target="#slideshow" data-slide-to="3"></li>
            <li data-target="#slideshow" data-slide-to="4"></li>
            <li data-target="#slideshow" data-slide-to="5"></li>
        </ul>

        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${pageContext.request.contextPath}/images/Slide/slideshow_1.jpg" alt="Picture"
                     style="height: 550px!important;">
            </div>

            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/images/Slide/slideshow_2.jpg" alt="Picture"
                     style="height: 550px!important;">
            </div>

            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/images/Slide/slideshow_3.gif" alt="Picture"
                     style="height: 550px!important;">
            </div>

            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/images/Slide/slideshow_4.jpg" alt="Picture"
                     style="height: 550px!important;">
            </div>

            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/images/Slide/slideshow_5.jpg" alt="Picture"
                     style="height: 550px!important;">
            </div>

            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/images/Slide/slideshow_6.jpg" alt="Picture"
                     style="height: 550px!important;">
            </div>
        </div>

        <a class="carousel-control-prev" href="#slideshow" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#slideshow" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>

    <div class="container pt-5">

        <div class="row pt-2 pb-4">
            <div class="col text-center">
                <aside>
                    <h2>Hot</h2>
                    <div class="title-line">
                        <h3 class="text-uppercase">Ưu đãi mỗi tuần</h3>
                    </div>
                </aside>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <a href="">
                    <img src="${pageContext.request.contextPath}/images/Content/slideshowsale_1.jpg.gif" alt="">
                </a>
            </div>

            <div class="col-sm-3">
                <a href="">
                    <img src="${pageContext.request.contextPath}/images/Content/slideshowsale_2.jpg" alt="">
                </a>
            </div>

            <div class="col-sm-3">
                <a href="">
                    <img src="${pageContext.request.contextPath}/images/Content/slideshowsale_3.jpg.gif" alt="">
                </a>
            </div>

            <div class="col-sm-3">
                <a href="">
                    <img src="${pageContext.request.contextPath}/images/Content/slideshowsale_4.jpg.gif" alt="">
                </a>
            </div>
        </div>

        <div class="row pt-4">
            <a href="">
                <img src="${pageContext.request.contextPath}/images/Content/190509_vn_bw_23fc5e1df46746b5a619e9b10d6cc30b.gif"
                     alt="" class="img-fluid " style="width: 98% ; height: 100%">
            </a>
        </div>

        <div class="row pt-2 pb-4">
            <div class="col text-center">
                <aside>
                    <h2>WHAT HOT</h2>
                    <div class="title-line">
                        <h3 class="text-uppercase">sản phẩm nổi bật</h3>
                    </div>
                </aside>
            </div>
        </div>

        <div class="row d-flex">
            <c:forEach items="${productListItem}" var="item" begin="0" end="9">
                <div class="cart-product pro-loop" style="width: 20%;">
                        <%--Image--%>
                    <div class="product-image shadow-sm rounded">
                        <a href="<c:url value="/product/${item.id}" /> ">
                            <img src="${pageContext.request.contextPath}/resources/images/${item.imagesList.get(0).name}"
                                 alt=""
                                 class="img-fluid first-image">
                            <img src="${pageContext.request.contextPath}/resources/images/${item.imagesList.get(1).name}"
                                 alt=""
                                 class="img-fluid second-image">
                        </a>

                        <div style="padding: 0 17px" class="actions d-flex justify-content-around">
                            <div class="actions-items col-md-2 d-flex justify-content-center align-items-center">
                                <a href="javascript:void(0);">
                                    <div class="">
                                        <i class="far fa-heart"></i>
                                    </div>
                                </a>
                            </div>

                            <div class="actions-items col-md-2 d-flex justify-content-center align-items-center add-to-cart"
                                 data-value="${item.id}">
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
                        <a href="<c:url value="/product/${item.id}" />" class="redirect-product">
                                ${item.name}
                        </a>
                    </div>
                    <div class="product-price text-center" name="productPrice">
                        <fmt:formatNumber value="${item.price}" type="currency"/>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="d-flex justify-content-center align-items-center" style="margin-bottom: 20px">
            <a href="<c:url value="/collections/top-san-pham-ban-chay"/>" class="btn button-default shadow rounded">XEM THÊM</a>
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
                Thêm thành công!
            </div>
        </div>
    </div>

    <script type="text/javascript">

        $(document).ready(function () {

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

        });
    </script>

</div>