<%--
  Created by IntelliJ IDEA.
  User: stuart
  Date: 12/19/18
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body class="body-text">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h2 class="head-text">Edit the ad!</h2>
    <form action="/ads/edit/confirm" method="post">
        <input type="hidden" name="ad_id" value="${sessionScope.ad_id}" style="display: none">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${sessionScope.ad_title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text">${sessionScope.ad_desc}</textarea>
        </div>
        <%--<c:forEach var="ad" items="${ads.categories}">--%>
            <%--Category A <input type="checkbox" name="categories" value="a">--%>
        <%--</c:forEach>--%>
        <input type="submit" class="btn btn-block btn-primary" value="Edit ad">
    </form>
</div>
</body>
</html>
