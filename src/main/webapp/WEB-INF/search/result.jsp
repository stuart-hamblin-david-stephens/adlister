<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body class="body-text">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 class="head-text">Here Are all the ads!</h1>
    <c:forEach var="ad" items="${ads_search}">
        <form id="submit-for-${ad.id}" action="" method="post">
            <div class="col-md-6" onclick="javascript:document.getElementById('submit-for-${ad.id}').submit();">
                <h2 class="head-text">${ad.title}</h2>
                <p>${ad.description}</p>
                <input type="hidden" name="ad_id" value="${ad.id}" style="display: none">
            </div>
        </form>
    </c:forEach>
</div>
<jsp:include page="/WEB-INF/partials/script.jsp"/>
</body>
</html>
