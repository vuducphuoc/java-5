
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Hello, world!</h1>
        <hr class="my-4">
        <div class="row">
            <div class="card col-md-4">
                <img src="" class="card-img-top" alt=>
                <div class="card-body">
                    <h5 class="card-title">${applicationScope.name}</h5>
                    <p class="card-text">${applicationScope.level*salary}</p>
                </div>
            </div>

            <div class="card col-md-4">
                <img src="" class="card-img-top" alt=>
                <div class="card-body">
                    <h5 class="card-title">${sessionScope.name}</h5>
                    <p class="card-text">${sessionScope.level*salary}</p>
                </div>
            </div>

            <div class="card col-md-4">
                <img src="" class="card-img-top" alt=>
                <div class="card-body">
                    <h5 class="card-title">${requestScope.name}</h5>
                    <p class="card-text">${requestScope.level*salary}</p>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
