<%--
  Created by IntelliJ IDEA.
  User: dastepps
  Date: 2018-12-14
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Register" />
    </jsp:include>
</head>
<body class="body-text">
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1 class="head-text">Please Register</h1>
        <form action="/register" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" value="${sessionScope.user_attempt}">
            </div>
            <div class="form-group">
                <label for="email">E-Mail</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="password-confirm">Confirm Password</label>
                <input id="password-confirm" name="password-confirm" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-info btn-block" value="Sign Up">
        </form>
    </div>
    <jsp:include page="/WEB-INF/partials/script.jsp"/>
</body>
</html>
