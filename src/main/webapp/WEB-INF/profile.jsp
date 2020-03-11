<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h2>Contracts You've Created</h2>

        <c:forEach var="contract" items="${contracts}">
            <div class="col-md-6">
                <h2>${contract.title}</h2>
                <p>${contract.description}</p>
            </div>
        </c:forEach>
    </div>




</body>
</html>
