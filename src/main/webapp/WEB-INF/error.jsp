<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1 class="head-text text-center">You weren't supposed to be here, you know...</h1>

    <div class="text-center">
        <img src="https://media.discordapp.net/attachments/248329263462219776/525415041030291467/sigh.gif" alt="oh no..." class="oops">
    </div>
</div>
</body>
</html>