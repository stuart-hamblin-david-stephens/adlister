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
<body>
    <div class="container">
        <h1>Edit Profile</h1>
        <form action="/edit-profile" method="post">
            <div class="form-group">
                <label for="username" >Username</label>
                <input id="username" name="username" class="form-control" type="text" placeholder="${sessionScope.user}">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <textarea id="email" name="email" class="form-control" type="text" placeholder="${sessionScope.email}"></textarea>
            </div>
            <div class="form-group">
                <label for="password">New Password</label>
                <textarea id="password" name="password" class="form-control" type="password"></textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
