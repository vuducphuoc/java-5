
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<html>
<head>
    <title>Bài 04 - Lab 04</title>
</head>
<body>
    <div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Bài 04 - Lab 04</h1>
        <hr class="my-4">
        <div class="row">
            <table class="table table-hover bg-white">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Giá tiền</th>
                    <th scope="col">Giảm giá</th>
                    <th scope="col">Giá mới</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${prods}" varStatus="count">
                    <tr>
                        <th scope="row">${count.index +1}</th>
                        <td>${item.name}</td>
                        <td>
                            <fmt:formatNumber value="${item.unitPrice}" type="currency"/>
                        </td>
                        <td>
                            <fmt:formatNumber value="${item.discount}" type="percent"/>
                        </td>
                        <td>
                            <fmt:formatNumber value="${item.getNewPrice()}" type="currency"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
