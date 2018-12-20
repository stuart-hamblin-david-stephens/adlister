<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default sticky-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header head-text">
            <a class="navbar-brand" href="/ads">
                <img src="https://media.discordapp.net/attachments/248329263462219776/525415008708853776/sticker-logo.png?width=600&height=600" alt="funny octoman" class="logo">
                <p class="text-logo">Fixer Lister</p>
            </a>
        </div>
        <ul class="nav navbar-nav navbar-right head-text">
            <li class="nav-item"><a href="/search" class="nav-link">Search Ads</a></li>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <li class="nav-item"><a href="/profile" class="nav-link">Profile</a></li>
                    <li class="nav-item"><a href="/profile/edit" class="nav-link">Edit Profile</a></li>
                    <li class="nav-item"><a href="/ads/create" class="nav-link">Create New Ad</a></li>
                    <li class="nav-item"><a href="/logout" class="nav-link">Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item"><a href="/register" class="nav-link">Register</a></li>
                    <li class="nav-item"><a href="/login" class="nav-link">Login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
