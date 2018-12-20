<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header head-text">
            <a class="navbar-brand" href="/ads">
                <img src="https://media.discordapp.net/attachments/248329263462219776/525415008708853776/sticker-logo.png?width=600&height=600" alt="funny octoman" class="logo">
                <p class="text-logo">Fixer Lister</p>
            </a>
        </div>
        <ul class="nav navbar-nav navbar-right head-text">
            <li><a href="/search">Search Ads</a></li>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <li><a href="/profile">Profile</a></li>
                    <li><a href="/profile/edit">Edit Profile</a></li>
                    <li><a href="/ads/create">Create New Ad</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/register">Register</a></li>
                    <li><a href="/login">Login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
