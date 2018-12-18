<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <form id="submit-for-${ad.id}" action="" method="post">
            <div class="col-md-6" onclick="javascript:document.getElementById('submit-for-${ad.id}').submit();">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
                <input type="hidden" name="ad_id" value="${ad.id}" style="display: none">
            </div>
        </form>
    </c:forEach>
</div>

</body>
</html>
