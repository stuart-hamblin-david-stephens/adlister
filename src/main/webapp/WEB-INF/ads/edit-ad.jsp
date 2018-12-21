<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.codeup.adlister.dao.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="div-inline text-center">
            <c:forEach items="${DaoFactory.getCatDao().all()}" var="category">
                <div class="div-inline">
                    <input class="form-check-input" type="checkbox" name="categories" id="category-${category.id}" value=${category.id}><label class="form-check-label" for="category-${category.id}">&nbsp;${category.title}&nbsp;&nbsp;&nbsp;</label>
                </div>
            </c:forEach>
        </div>
        <br>
        <input type="submit" class="btn btn-block btn-info" value="Edit ad">
    </form>
</div>
<jsp:include page="/WEB-INF/partials/script.jsp"/>
</body>
</html>
