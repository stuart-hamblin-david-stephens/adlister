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
        <h1 class="head-text">Welcome to the Fixer Lister!</h1>
        <img src="https://media.discordapp.net/attachments/248329263462219776/531861188116480037/yellow-monster.png?width=573&height=600" alt="yellow monster man" class="monster animated slideInUp delay-5s">
    </div>
    <jsp:include page="/WEB-INF/partials/script.jsp"/>
</body>
</html>
