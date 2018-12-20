<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body class="body-text">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 class="head-text">This Ad:</h1>

    <div class="col-md-6">
        <h2 class="head-text">${ad.title}</h2>
        <p>${ad.description}</p>
    </div>

</div>
<jsp:include page="/WEB-INF/partials/script.jsp"/>
</body>
</html>
