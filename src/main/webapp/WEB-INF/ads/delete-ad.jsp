<%--
  Created by IntelliJ IDEA.
  User: stuart
  Date: 12/19/18
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <form action="/ads/delete" method="post">
        <input type="hidden" name="ad_id" value="${ad.id}" style="display: none">
        <h2>Are you sure you want to delete this ad?</h2>
        <input type="submit" value="Yes. Delete this ad." class="col-md-3 btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
