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
    <h1><%= request.getParameter("title") %></h1>
    <h2><%= request.getParameter("reward") %></h2>
    <h3><%= request.getParameter("location") %></h3>
    <p><%= request.getParameter("description") %></p>
</div>
</body>
</html>
