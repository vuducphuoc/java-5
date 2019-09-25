<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Layout</title>
    <link rel="stylesheet" href="resources/Bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="resources/Bootstrap/fontawesome/fontawesome.css">
    <link rel="stylesheet" href="resources/Bootstrap/fontstyle/roboto.css">
    <link rel="stylesheet" href="resources/MyStyle/style.css">
    <link rel="stylesheet" href="resources/Bootstrap/sweetalert/dist/sweetalert2.min.css">
    <script type="text/javascript" src="resources/Bootstrap/jquery/jquery.min.js"></script>
    <base href="${pageContext.servletContext.contextPath}/">


</head>
<body>
<div class="container">
    <header>
        <h1>
            <fmt:message bundle="${lang}" key="global.company" />
        </h1>
    </header>

    <%--Narbar--%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <%@ include file="web/user-menu.jsp"%>
    </nav>

    <div class="content">
        <div class="row">
            <div class="col-md-8">
                <article>
                    <jsp:include page="${param.view}"/>
                </article>
            </div>
            <div class="col-md-4">
                <aside>CONTROL PANEL</aside>
            </div>
        </div>
    </div>
    <%--Content--%>
    <%--Side Bar Right--%>
    <footer>FOOTER</footer>
</div>

<script>

    $(function () {
        $("a[data-lang]").click(function(){
            var lang = $(this).attr("data-lang");
            $.ajax({
                type: 'POST',
                url: 'api/language',
                data: {
                    language: lang
                },
                success: function (value) {
                    window.location.reload();
                }
            })
            return false;
        });
    })
</script>

<!-- SCRIPT ============================================================-->
<script type="text/javascript" src="resources/Bootstrap/fontawesome/fontawesome.js"></script>
<script type="text/javascript" src="resources/Bootstrap/sweetalert/dist/sweetalert2.all.min.js"></script>
<script type="text/javascript" src="resources/Bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/Bootstrap/js/wow.min.js"></script>
<script type="text/javascript" src="resources/Bootstrap/js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="resources/MyStyle/custom.js"></script>
</body>
</html>
