<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>Welcome, ${sessionScope.user}!</h1> <a href="/profile/edit">Edit Profile</a>
    <h2>Your current ads</h2>
        <%!  %>
        <c:forEach var="ad" items="${userAds}">
            <div class="col-md-6">
                <div class="col-md-12 px-0">
                    <form id="submit-for-${ad.id}" action="" method="post">
                        <div onclick="javascript:document.getElementById('submit-for-${ad.id}').submit();">
                            <h2>${ad.title}</h2>
                            <p>${ad.description}</p>
                            <input type="hidden" name="ad_id" value="${ad.id}" style="display: none">
                        </div>
                    </form>
                    <div class="col-md-2">
                        <a href="/ad/edit">Edit Ad</a>
                    </div>
                    <div class="col-md-2">
                        <form action="/ads/delete" method="post" id="delete-for-${ad.id}">
                            <input type="hidden" name="ad_id" value="${ad.id}">
                            <button type="submit">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
