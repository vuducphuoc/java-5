<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="../taglib.jsp" %>

<!DOCTYPE html>

<style>
    .dropdown-toggle-ellipsis::after {
        display: none;
    }

    .dropdown-toggle-ellipsis::before {
        display: inline-block;
        padding: 0.5rem;
        font: normal normal normal 14px/1 FontAwesome;
        content: "\f142";
    }
</style>

<div class="group_sidebar col col-md-3">

    <div class="list-group sidebar">
        <div class="sb-title">
            <h3 class="sb-title-text">Danh mục</h3>
        </div>

        <ul class="list-group list-group-flush">

            <li class="list-group-item">
                <a href="<c:url value="/collections/hang-moi-ve"/>">
                    Hàng mới về
                </a>
            </li>

            <li class="list-group-item">

                <a href="#sub-item-1" data-toggle="collapse"  class="collapsed" aria-expanded="true">
                    Giảm giá
                </a>

                <div class="collapse list-group" id="sub-item-1" data-parent=".sidebar">
                    <a class="list-group-item" href="/collections/summer-sale-up-to-60" title="Holidays Sale up to 60%">
                        <span>Holidays Sale up to 60%</span>
                    </a>

                    <a class="list-group-item" href="/collections/mua-2-gia-199-000-vnd" title="Mua 2 giá 199,000">
                        <span>Mua 2 giá 199,000</span>
                    </a>

                    <a class="list-group-item" href="/collections/mua-2-gia-249-000" title="Mua 2 giá 249,000">
                        <span>Mua 2 giá 249,000</span>
                    </a>

                    <a class="list-group-item" href="/collections/mua-2-gia-349-000-vnd" title="Mua 2 giá 349,000">
                        <span>Mua 2 giá 349,000</span>
                    </a>

                    <a class="list-group-item" href="/collections/airspacevn-sales" title="Mua 2 giá 449,000">
                        <span>Mua 2 giá 449,000</span>
                    </a>

                    <a class="list-group-item" href="/collections/wow-so-skinny-1" title="Mua 2 giá 519,000">
                        <span>Mua 2 giá 519,000</span>
                    </a>
                </div>
            </li>

            <li class="list-group-item">
                <a href="#">
                    <span class="lbl">Top Sản Phẩm Bán Chạy</span>
                    <span data-toggle="collapse" data-parent="#cssmenu" href="#sub-item-3" class="sign drop-down">
											</span>
                </a>

                <ul class="nav children collapse list-group" id="sub-item-3">
                    <li class="firstlast list-group-item">
                        <a href="/collections/back-in-stock" title="Back In Stock">
                            <span>Back In Stock</span>
                        </a>
                    </li>
                </ul>
            </li>

            <li class="item  list-group-item">
                <a href="/collections/wow-so-skinny">
                    <span>Quần skinny thon gọn</span>
                </a>
            </li>

            <li class="item  last list-group-item">
                <a href="/collections/noi-y">
                    <span>Áo nâng ngực</span>
                </a>
            </li>
        </ul>
    </div>

    <!-- Banner quảng cáo -->
    <div class="list-group_l banner-left hidden-sm hidden-xs">
    </div>
</div>

