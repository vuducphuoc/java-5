<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:choose>
    <c:when test="${language == 'en'}" >
        <fmt:setBundle basename="global_${language}" var="lang" />
    </c:when>
    <c:otherwise>
        <fmt:setBundle basename="global_vi" var="lang" />
    </c:otherwise>
</c:choose>