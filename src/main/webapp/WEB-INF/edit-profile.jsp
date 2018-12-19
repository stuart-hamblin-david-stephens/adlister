<%--
  Created by IntelliJ IDEA.
  User: stuart
  Date: 12/17/18
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Profile" />
    </jsp:include>
</head>
<body class="body-text">
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1 class="head-text">Edit Profile</h1>
        <form action="/profile/edit" method="post">
            <div class="form-group">
                <label for="username" >Username</label>
                <input id="username" name="username" class="form-control" type="text" value="${sessionScope.user}">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" value="${sessionScope.email}">
            </div>
            <div class="form-group">
                <label for="current-password">Current Password *</label>
                <input id="current-password" name="current-password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="password">New Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="password-confirm">Confirm New Password</label>
                <input id="password-confirm" name="password-confirm" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
        <div class="text-right text-muted">
            * = required field
        </div>
    </div>
</body>
</html>
