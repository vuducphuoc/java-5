<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sản phầm chi tiết</title>
</head>

<body>
    <section class="detail-product">
        <div class="row">
            <div class="col-md-6">
                <div id="surround">
                    <img class="img-fluid" src="<c:url value="resources/Image/Product/${productItem.getImage()[0]}" />" alt="${productItem.getName()}">
                </div>
            </div>

            <div class="col-md-6">

                <div class="product-title">
                    <h2>${productItem.getName()}</h2>
                    <span id="pro_sku" class="text-info">SKU: ${productItem.getId()}</span>
                </div>

                <div class="product-price" id="price-preview">
                    <span><fmt:formatNumber value ="${productItem.getPrice()}" type ="currency"/></span>
                </div>

                <%--<form id="add-item-form">--%>
                <div class="select clearfix">

                    <div class="form-group">
                        <label for="product-select-option-0">Màu sắc</label>
                        <div class="custom-dropdown custom-dropdown--white">
                            <select class="custom-select product-select" data-option="option1" id="product-select-option-0">
                                <c:forEach var="item" items="${productItem.getColorList()}">
                                    <option value="${item.getId()}">${item.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="product-select-option-1">Kích thước</label>
                        <div class="custom-dropdown custom-dropdown--white">
                            <select class="custom-select product-select" data-option="option2" id="product-select-option-1">
                                <c:forEach var="item" items="${productItem.getSizeList()}">
                                    <option value="${item.getId()}">${item.getName()}</option>
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
                        <button id="add-to-cart" class="btn button-default" data-value="${productItem.getId()}">
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
                <%--</form>--%>

                <h3 class="pt-3 pb-3">ĐĂNG KÝ THÔNG TIN MUA HÀNG</h3>

                <div class="pt20">
                    <!-- Begin tags -->
                    <div class="tag-wrapper">
                        <label>
                            Tags:
                        </label>
                        <ul class="tags">

                            <li class="active">
                                <a href="/collections/all/spbc">SPBC</a>
                            </li>
                        </ul>
                    </div>
                    <!-- End tags -->
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

    <script type="text/javascript">
        $(document).ready(function() {
            $('#add-to-cart').click(function () {
                var idProduct = $(this).attr('data-value');
                var color = $('#product-select-option-0').val();
                var size = $('#product-select-option-1').val();
                var quantity = $('#quantity').val();
                $.ajax({
                    url: 'api/add-to-cart',
                    type: 'POST',
                    data: {
                        idProduct: idProduct,
                        idColor: color,
                        idSize: size,
                        quantity: quantity
                    },
                    success: function (value) {
                        $('#cart-quantity').text(parseInt(value));
                        Swal.fire({
                            position: 'top-end',
                            type: 'success',
                            title: 'Thêm thành công!',
                            showConfirmButton: false,
                            timer: 1500
                        })
                    }
                })
            })
        })
    </script>

</body>

</html>
