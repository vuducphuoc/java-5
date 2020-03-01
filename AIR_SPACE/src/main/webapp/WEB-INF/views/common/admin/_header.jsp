<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../taglib.jsp" %>
<!DOCTYPE html>

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="col-md-3 d-flex justify-content-center align-items-center">
            <div class="col-auto">
                <span style="font-size:30px;cursor:pointer" id="toggle-sidebar">&#9776;</span>
            </div>
            <div class="col-auto">
                <a class="navbar-brand" href="#"> AIR-SPACE</a>
            </div>
        </div>

        <div class="col-md-9">
            <div class="collapse navbar-collapse float-right" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Avatar</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<script>
    $(function () {
        $('#toggle-sidebar').click(function () {
            if ($('.group_sidebar').width() == "250") {
                $('.group_sidebar').css('width', '0');
            } else {
                $('.group_sidebar').css('width', '250px');
            }
        })
    })
</script>
