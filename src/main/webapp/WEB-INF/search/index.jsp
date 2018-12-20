<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body class="body-text">
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h2 class="head-text">What would you like to search?</h2>
        <form action="/search/result" method="post" name="search-form">
            <div class="row mb-5">
                <div class="col-md-4">
                    <label class="mr-sm-2" for="search-by">Search by</label>
                    <select class="form-control mr-sm-2 col-2" id="search-by" name="search-by">
                        <option value="1" selected>Title</option>
                        <option value="2">User</option>
                        <option value="3">Category</option>
                    </select>
                </div>
                <div class="col-md-8">
                    <label for="search-term">Name</label>
                    <input type="text" class="form-control col-8 mb-2 mr-sm-2" id="search-term" name="search-term" placeholder="What are you looking for?">
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-info btn-block my-2">Submit</button>
        </form>
    </div>

</body>
</html>
