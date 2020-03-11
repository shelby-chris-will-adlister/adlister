<%--
  Created by IntelliJ IDEA.
  User: shelbyhughes
  Date: 3/10/20
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Scarlet Carson Society" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>${contract.title}</h1>
    <h2>${contract.reward}</h2>
    <h3>${contract.country}</h3>
    <p>${contract.description}</p>
</div>
</body>
</html>
