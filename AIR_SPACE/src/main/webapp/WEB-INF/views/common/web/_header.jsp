<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../taglib.jsp" %>

<!DOCTYPE html>

<div id="header">
    <div class="container">
        <div class="row  pt-4 pb-3 align-items-center">
            <%--Logo--%>
            <div class="col-md-4">
                <a href="<c:url value="/" />"> <img src="${pageContext.request.contextPath}/images/Header/logo.png" alt="Logo"> </a>
            </div>

            <div class="col-md-6 offset-2">
                <div class="row">
                    <div class="col-md-9">
                        <div class="row justify-content-center">
                            <nav class="navbar navbar-expand" id="navLogin">
                                <ul class="list-unstyled navbar-nav" id="nav_header">
                                    <li>
                                        Gọi điện đặt hàng
                                        <i class="fa fa-phone" aria-hidden="true"></i>
                                        <span>0966-434-100</span>
                                    </li>

                                    <c:choose>
                                        <c:when test="${userLogin != null}">
                                            <li>
                                                <a href="<c:url value="/account"/>" class="text-uppercase"> Tài khoản của tôi</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li>
                                                <a href=" <c:url value='/register'/> " class="text-uppercase" id="registration">
                                                    <fmt:message key="btn.register" bundle="${lang}" />
                                                </a>
                                            </li>
                                            <li>
                                                <a href=" <c:url value='/login' /> " class="text-uppercase" id="login">
                                                    <fmt:message key="btn.login" bundle="${lang}"/>
                                                </a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </nav>
                        </div>

                        <div class="row text-center">
                            <div class="col pt-2">
                                <p style="font-Size_Entity: 12px">
                                    Miễn phí vận chuyển
                                    <span class="text-danger" style="font-Size_Entity: 12px"> áp dụng với đơn hàng có giá trị từ 500k </span>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="cartInfo">
                            <a class="cartLink" href="<c:url value='/cart' />">
                                <span class="iconCart">
							</span>
                                <div class="cartNumber" id="cart-quantity">
                                    <c:choose>
                                        <c:when test="${not empty myCartList}">
                                            ${myCartList.size()}
                                        </c:when>
                                        <c:otherwise>
                                            0
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
