<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>

<body>
<!-- Header -->
<!-- SlidesEntity Show -->
<div id="slideshow" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ul class="carousel-indicators">
        <li data-target="#slideshow" data-slide-to="0" class="active"></li>
        <li data-target="#slideshow" data-slide-to="1"></li>
        <li data-target="#slideshow" data-slide-to="2"></li>
        <li data-target="#slideshow" data-slide-to="3"></li>
        <li data-target="#slideshow" data-slide-to="4"></li>
        <li data-target="#slideshow" data-slide-to="5"></li>
    </ul>

    <!-- The slideshow -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="resources/Image/Slide/slideshow_1.jpg" alt="Picture" style="height: 550px!important;">
        </div>

        <div class="carousel-item">
            <img src="resources/Image/Slide/slideshow_2.jpg" alt="Picture" style="height: 550px!important;">
        </div>

        <div class="carousel-item">
            <img src="resources/Image/Slide/slideshow_3.gif" alt="Picture" style="height: 550px!important;">
        </div>

        <div class="carousel-item">
            <img src="resources/Image/Slide/slideshow_4.jpg" alt="Picture" style="height: 550px!important;">
        </div>

        <div class="carousel-item">
            <img src="resources/Image/Slide/slideshow_5.jpg" alt="Picture" style="height: 550px!important;">
        </div>

        <div class="carousel-item">
            <img src="resources/Image/Slide/slideshow_6.jpg" alt="Picture" style="height: 550px!important;">
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="carousel-control-prev" href="#slideshow" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#slideshow" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div> <!-- End of SlidesEntity SHow -->
<!-- Content -->
<div id="content" class="container pt-5">

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
                <img src="resources/Image/Content/slideshowsale_1.jpg.gif" alt="">
            </a>
        </div>

        <div class="col-sm-3">
            <a href="">
                <img src="resources/Image/Content/slideshowsale_2.jpg" alt="">
            </a>
        </div>

        <div class="col-sm-3">
            <a href="">
                <img src="resources/Image/Content/slideshowsale_3.jpg.gif" alt="">
            </a>
        </div>

        <div class="col-sm-3">
            <a href="">
                <img src="resources/Image/Content/slideshowsale_4.jpg.gif" alt="">
            </a>
        </div>
    </div>

    <div class="row pt-4">
        <a href="">
            <img src="resources/Image/Content/190509_vn_bw_23fc5e1df46746b5a619e9b10d6cc30b.gif"
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

    <%--Product--%>
    <div class="row pb-5 justify-content-center">
        <c:forEach items="${listProducts}" var="product" begin="5" end="9">
            <div class="cart-product pro-loop">
                    <%--Image--%>
                <div class="product-image row">
                    <a href="<c:url value="/product/${product.getId()}" /> ">
                        <img src="<c:url value="resources/Image/Product/${product.getImage()[0]}" /> " alt=""
                             class="img-fluid first-image">
                        <img src="resources/Image/Product/${product.getImage()[1]}" alt=""
                             class="img-fluid second-image">
                    </a>

                    <div class="actions row">
                        <div class="col-md-3">
                            <a href="javascript:void(0);">
                                <div class="actions-items">
                                    <i class="far fa-heart"></i>
                                </div>
                            </a>
                        </div>

                        <div class="col-md-3">
                            <a href="javascript:void(0);">
                                <div class="actions-items add-to-cart" data-value="${product.getId()}">
                                    <i class="fas fa-shopping-bag"></i>
                                </div>
                            </a>
                        </div>

                        <div class="col-md-3">
                            <a href="javascript:void(0);">
                                <div class="actions-items">
                                    <i class="far fa-clone"></i>
                                </div>
                            </a>
                        </div>

                        <div class="col-md-3">
                            <a href="javascript:void(0);">
                                <div class="actions-items">
                                    <i class="fas fa-eye"></i>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>

                    <%--Name--%>
                <div class="product-name text-center" name="productName">
                    <a href="<c:url value="/product/${product.getId()}" />" class="redirect-product">
                            ${product.getName()}
                    </a>
                </div>
                <div class="product-price text-center" name="productPrice">
                    <fmt:formatNumber value="${product.getPrice()}" type="currency"/>
                </div>
            </div>
        </c:forEach>
    </div>
    <%--End Produt--%>

</div>

    <script type="text/javascript">
    $(document).ready(function () {
        $('.add-to-cart').click(function () {
            var product = $(this).attr('data-value');
            $.ajax({
                url: 'api/add-to-cart',
                type: 'POST',
                data: {
                    idProduct: product
                },
                success: function (value) {
                    $('#cart-quantity').text(parseInt(value));
                }
            })
        })
    });
</script>

</body>
</html>