<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../common/taglib.jsp" %>

<!DOCTYPE html>

<style>

    @media (min-width: 768px) {

        /* show 3 items */
        .carousel-inner .active,
        .carousel-inner .active + .carousel-item,
        .carousel-inner .active + .carousel-item + .carousel-item,
        .carousel-inner .active + .carousel-item + .carousel-item + .carousel-item  {
            display: block;
        }

        .carousel-inner .carousel-item.active:not(.carousel-item-right):not(.carousel-item-left),
        .carousel-inner .carousel-item.active:not(.carousel-item-right):not(.carousel-item-left) + .carousel-item,
        .carousel-inner .carousel-item.active:not(.carousel-item-right):not(.carousel-item-left) + .carousel-item + .carousel-item,
        .carousel-inner .carousel-item.active:not(.carousel-item-right):not(.carousel-item-left) + .carousel-item + .carousel-item + .carousel-item {
            transition: none;
        }

        .carousel-inner .carousel-item-next,
        .carousel-inner .carousel-item-prev {
            position: relative;
            transform: translate3d(0, 0, 0);
        }

        .carousel-inner .active.carousel-item + .carousel-item + .carousel-item + .carousel-item + .carousel-item {
            position: absolute;
            top: 0;
            right: -25%;
            z-index: -1;
            display: block;
            visibility: visible;
        }

        /* left or forward direction */
        .active.carousel-item-left + .carousel-item-next.carousel-item-left,
        .carousel-item-next.carousel-item-left + .carousel-item,
        .carousel-item-next.carousel-item-left + .carousel-item + .carousel-item,
        .carousel-item-next.carousel-item-left + .carousel-item + .carousel-item + .carousel-item,
        .carousel-item-next.carousel-item-left + .carousel-item + .carousel-item + .carousel-item + .carousel-item {
            position: relative;
            transform: translate3d(-100%, 0, 0);
            visibility: visible;
        }

        /* farthest right hidden item must be abso position for animations */
        .carousel-inner .carousel-item-prev.carousel-item-right {
            position: absolute;
            top: 0;
            left: 0;
            z-index: -1;
            display: block;
            visibility: visible;
        }

        /* right or prev direction */
        .active.carousel-item-right + .carousel-item-prev.carousel-item-right,
        .carousel-item-prev.carousel-item-right + .carousel-item,
        .carousel-item-prev.carousel-item-right + .carousel-item + .carousel-item,
        .carousel-item-prev.carousel-item-right + .carousel-item + .carousel-item + .carousel-item,
        .carousel-item-prev.carousel-item-right + .carousel-item + .carousel-item + .carousel-item + .carousel-item {
            position: relative;
            transform: translate3d(100%, 0, 0);
            visibility: visible;
            display: block;
            visibility: visible;
        }
    }

</style>

<div class="col col-md-9">
    <section class="detail-product">
        <div class="row">
            <div class="col col-md-6">

                <div id="surround">
                    <img class="img-fluid" id="product-image"
                         src="<c:url value="/resources/images/${productItem.imagesList.get(0).name}" />"
                         alt="${productItem.name}">
                </div>

                <div id="carouselExample" class="carousel slide mt-3 mb-3" data-ride="carousel"data-type="multi" data-interval="9000">
                    <div class="carousel-inner row  mx-auto" role="listbox">
                        <c:forEach var="item" items="${productItem.imagesList}" varStatus="status">
                            <div class="carousel-item m-0 col-sm-3 ${status.count == 1 ? 'active':''}">
                                <div class="panel panel-default">
                                    <div class="panel-thumbnail">
                                        <a href="#" title="image 1" class="thumb"
                                           data-color-id="${item.color.id}" data-product-id="${productItem.id}">
                                            <img class="img-fluid mx-auto d-block rounded shadow"
                                                 src="<c:url value="/resources/images/${item.name}" />" alt="slide 1">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExample" role="button" data-slide="prev" style="width: 20px">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next text-faded" href="#carouselExample" role="button" data-slide="next" style="width: 20px">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>

            <div class="col col-md-6">
                <div class="product-title">
                    <h2>${productItem.name}</h2>
                    <span id="pro_sku" class="text-info">SKU: ${productItem.id}</span>
                </div>

                <div class="product-price" id="price-preview">
                    <span><fmt:formatNumber value="${productItem.price}" type="currency"/></span>
                </div>

                <div class="select clearfix">

                    <%--Select Color --%>
                    <div class="form-group">
                        <label for="product-select-option-0">Màu sắc</label>
                        <div class="custom-dropdown custom-dropdown--white">
                            <select class="custom-select product-select" data-option="option1" data-product-id="${productItem.id}"
                                    id="product-select-option-0">
                                <c:forEach var="item" items="${productItem.colorsList}">
                                    <option value="${item.id}">${item.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <%-- Select Size --%>
                    <div class="form-group">
                        <label for="product-select-option-1">Kích thước</label>
                        <div class="custom-dropdown custom-dropdown--white">
                            <select class="custom-select product-select" data-option="option2"
                                    id="product-select-option-1">
                                <c:forEach var="item" items="${productItem.sizesList}">
                                    <option value="${item.id}">${item.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="quantity">Số lượng</label>
                    <div>
                        <input id="quantity" type="number" name="quantity" min="1" value="1" class="product-select">
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-6 col-md-12 col-sm-6 col-xs-12">
                        <button id="add-to-cart" class="btn button-default" data-value="${productItem.id}">
                            <span class="icon-add-to-cart">
                                <i class="fas fa-cart-plus"></i>
                            </span>
                            Thêm vào giỏ
                        </button>
                    </div>

                    <div class="col-lg-6 col-md-12 col-sm-6 col-xs-12">
                        <button id="buy-now" class="btn button-default">
                            <span class="icon-buy-now">
                                <i class="fas fa-check"></i>
                            </span>
                            Mua ngay
                        </button>
                    </div>
                </div>

                <h3 class="pt-3 pb-3">ĐĂNG KÝ THÔNG TIN MUA HÀNG</h3>

                <div class="pt20">
                    <div class="tag-wrapper">
                        <label>
                            Tags:
                        </label>
                        <ul class="tags">

                            <li class="active">
                                <a href="<c:url value="/collections" />">SPBC</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <!-- <div class="addthis_toolbox addthis_default_style ">

                    <div class="info-socials-article clearfix">
                        <div class="box-like-socials-article">
                            <div class="fb-send" data-href="/products/19218383">
                            </div>
                        </div>
                        <div class="box-like-socials-article">
                            <div class="fb-like fb_iframe_widget" data-href="/products/19218383" data-layout="button_count" data-action="like" fb-xfbml-state="rendered" fb-iframe-plugin-query="action=like&amp;app_id=363772567412181&amp;container_width=0&amp;href=https%3A%2F%2Fvn.airspaceonline.com%2Fproducts%2F19218383&amp;layout=button_count&amp;locale=vi_VN&amp;sdk=joey"><span style="vertical-align: bottom; width: 68px; height: 20px;"><iframe name="f278523ded65f82" title="fb:like Facebook Social Plugin" allowtransparency="true" allowfullscreen="true" scrolling="no" allow="encrypted-media" style="border: medium none; visibility: visible; width: 68px; height: 20px;" src="https://www.facebook.com/v3.2/plugins/like.php?action=like&amp;app_id=363772567412181&amp;channel=https%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D44%23cb%3Df35e21f5a7172e%26domain%3Dvn.airspaceonline.com%26origin%3Dhttps%253A%252F%252Fvn.airspaceonline.com%252Ff3c0a8388b40cba%26relation%3Dparent.parent&amp;container_width=0&amp;href=https%3A%2F%2Fvn.airspaceonline.com%2Fproducts%2F19218383&amp;layout=button_count&amp;locale=vi_VN&amp;sdk=joey" class="" width="1000px" height="1000px" frameborder="0"></iframe></span></div>
                        </div>
                        <div class="box-like-socials-article">
                            <div class="fb-share-button fb_iframe_widget" data-href="/products/19218383" data-layout="button_count" fb-xfbml-state="rendered" fb-iframe-plugin-query="app_id=363772567412181&amp;container_width=0&amp;href=https%3A%2F%2Fvn.airspaceonline.com%2Fproducts%2F19218383&amp;layout=button_count&amp;locale=vi_VN&amp;sdk=joey"><span style="vertical-align: bottom; width: 79px; height: 20px;"><iframe name="ff35f5bf939656" title="fb:share_button Facebook Social Plugin" allowtransparency="true" allowfullscreen="true" scrolling="no" allow="encrypted-media" style="border: medium none; visibility: visible; width: 79px; height: 20px;" src="https://www.facebook.com/v3.2/plugins/share_button.php?app_id=363772567412181&amp;channel=https%3A%2F%2Fstaticxx.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D44%23cb%3Df28732fb752985c%26domain%3Dvn.airspaceonline.com%26origin%3Dhttps%253A%252F%252Fvn.airspaceonline.com%252Ff3c0a8388b40cba%26relation%3Dparent.parent&amp;container_width=0&amp;href=https%3A%2F%2Fvn.airspaceonline.com%2Fproducts%2F19218383&amp;layout=button_count&amp;locale=vi_VN&amp;sdk=joey" class="" width="1000px" height="1000px" frameborder="0"></iframe></span></div>
                        </div>
                    </div>
                </div> -->
            </div>
        </div>
    </section>

</div>

<script type="text/javascript">

    $(document).ready(function () {

        $('#add-to-cart').click(function () {
            var idProduct = $(this).attr('data-value');
            var color = $('#product-select-option-0').val();
            var size = $('#product-select-option-1').val();
            var quantity = $('#quantity').val();
            $.ajax({
                url: '${pageContext.request.contextPath}/api/add-to-cart',
                type: 'POST',
                data: {
                    productID: idProduct,
                    colorID: color,
                    sizeID: size,
                    quantity: quantity
                },
                success: function (value) {
                    $('#cart-quantity').text(parseInt(value));
                }
            })
        })

        $('.thumb').click(function (event) {
            event.preventDefault();

            var proID = $(this).attr('data-product-id');
            var colID = $(this).attr('data-color-id');
            var src = $(this).find('img').attr('src');

            $('#product-image').attr('src', src);
            if ($('#product-select-option-0').val() != colID) {
                $('#product-select-option-0').val(colID);
                changeDataSizeAndQuantity(proID, colID);
            }
        })

        $('#product-select-option-0').change(function () {
            var colID = $(this).val();
            var proID = $(this).attr('data-product-id');

            changeDataSizeAndQuantity(proID, colID);
        })

        function changeDataSizeAndQuantity(proID, colID) {
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath}/api/getProductDetail',
                data: {
                    proID: proID,
                    colID: colID
                },success: function (value) {
                    var listData = JSON.parse(JSON.stringify(value));
                    var listSize = [];
                    $.each(listData, function (index, data) {
                        listSize.push(data.size.id);
                    })

                    $('#product-select-option-1 > option').each(function () {
                        var value = $(this).val();
                        var count = $.inArray(parseInt(value), listSize);
                        if (count != -1){
                            $(this).removeClass('d-none');
                        } else {
                            $(this).addClass('d-none');
                        }
                    })
                    $('#product-select-option-1').val($('#product-select-option-1 > option:not(".d-none")').first().val());
                }
            })
        }
    })

</script>
