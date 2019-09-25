
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>


    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/" />">
                <fmt:message bundle="${lang}" key="global.menu.home" />
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/about" />">
                <fmt:message bundle="${lang}" key="global.menu.about" />
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="" data-lang="en">English</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="" data-lang="vi">Tiếng Việt</a>
        </li>
    </ul>

