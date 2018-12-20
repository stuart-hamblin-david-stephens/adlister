<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.codeup.adlister.dao.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body class="body-text">
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1 class="head-text">Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>

            <%--<% request.setAttribute("categories", DaoFactory.getAdsDao().allCategories());--%>
            <%----%>
            <%----%>
            <%--%>--%>
            <c:forEach items="${DaoFactory.getAdsDao().allCategories()}" var="category">
                <p>${category}</p><input type="checkbox" name="categories" value=${category}>
            </c:forEach>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
    <jsp:include page="/WEB-INF/partials/script.jsp"/>
</body>
</html>
