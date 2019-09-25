<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phuoc.bleach
  Date: 10/09/19
  Time: 9:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div class="container">
        <div class="jumbotron">
            <h1 class="display-4">Bài 02 - Lab 04</h1>
            <hr class="my-4">
            <div class="row">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Họ và tên</th>
                            <th>Điểm TB</th>
                            <th>Chuyên ngành</th>
                            <th>Danh hiệu</th>
                            <th>Xếp loại</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${bean.getName()}</td>
                            <td>${bean.getMark()}</td>
                            <td>${bean.getMajor()}</td>
                            <td>
                                <c:if test="${bean.getMark() >= 9}" >Ong Vàng</c:if>
                            </td>
                            <td>
                                <c:choose >
                                    <c:when test="${bean.getMark() < 5}" >Yếu</c:when>
                                    <c:when test="${bean.getMark() < 6.5}" >Trung Bình</c:when>
                                    <c:when test="${bean.getMark() < 7.5}" >Khá</c:when>
                                    <c:when test="${bean.getMark() < 9}" >Giỏi</c:when>
                                    <c:otherwise>Xuất Sắc</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td>${list.get(0).getName()}</td>
                            <td>${list.get(0).getMark()}</td>
                            <td>${list.get(0).getMajor()}</td>
                            <td>
                                <c:if test="${list.get(0).getMark() >= 9}" >Ong Vàng</c:if>
                            </td>
                            <td>
                                <c:choose >
                                    <c:when test="${list.get(0).getMark() < 5}" >Yếu</c:when>
                                    <c:when test="${list.get(0).getMark() < 6.5}" >Trung Bình</c:when>
                                    <c:when test="${list.get(0).getMark() < 7.5}" >Khá</c:when>
                                    <c:when test="${list.get(0).getMark() < 9}" >Giỏi</c:when>
                                    <c:otherwise>Xuất Sắc</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>

                        <tr>
                            <td>${map.get('KietLPT').getName()}</td>
                            <td>${map.get('KietLPT').getMark()}</td>
                            <td>${map.get('KietLPT').getMajor()}</td>
                            <td>
                                <c:if test="${map.get('KietLPT').getMark() >= 9}" >Ong Vàng</c:if>
                            </td>
                            <td>
                                <c:choose >
                                    <c:when test="${map.get('KietLPT').getMark() < 5}" >Yếu</c:when>
                                    <c:when test="${map.get('KietLPT').getMark() < 6.5}" >Trung Bình</c:when>
                                    <c:when test="${map.get('KietLPT').getMark() < 7.5}" >Khá</c:when>
                                    <c:when test="${map.get('KietLPT').getMark() < 9}" >Giỏi</c:when>
                                    <c:otherwise>Xuất Sắc</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
