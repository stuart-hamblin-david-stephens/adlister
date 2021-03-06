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
<body class="body-text">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <form action="/ads/delete/confirm" method="post">
        <input type="hidden" name="ad_id" value="${ad.id}" style="display: none">
            <div class="col-md-12">
                <h2 class="head-text">Are you sure you want to delete this ad?</h2>
            </div>
            <div class="col-md-4">
                <input type="submit" value="Yes. Delete this ad." class="col-md-3 btn btn-block btn-primary">
            </div>
    </form>
</div>
<jsp:include page="/WEB-INF/partials/script.jsp"/>
</body>
</html>
