<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Contracts" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the contract!</h1>

    <c:forEach var="contract" items="${contracts}">
        <div class="col-md-6">
            <h2>${contract.title}</h2>
            <p>${contract.description}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>
