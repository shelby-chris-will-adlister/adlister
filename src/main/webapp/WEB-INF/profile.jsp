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
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

    <div class="container">
        <h2><a href="/contracts">See Adds Available for Your Skill-Set</a></h2>
    </div>

    <div class="container">
        <h2>See Adds Available for Your Skill-Set</h2>
    </div>


</body>
</html>
