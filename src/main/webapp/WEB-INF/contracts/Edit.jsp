<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Add contract" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Edit a contract</h1>
    <form action="/contracts/edit" method="POST">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" name="title" id="title" class="form-control" value="<c:out value='${contract.title}' />"/>
        </div>
        <div class="form-group">
            <label for="reward">Reward</label>
            <input type="text" name="reward" id="reward" class="form-control" value="<c:out value='${contract.reward}' />"/>
        </div>
        <div class="form-group">
            <label for="country">Country</label>
            <input type="text" name="country" id="country" class="form-control" value="<c:out value='${contract.country}' />"/>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" name="description" id="description" class="form-control" value="<c:out value='${contract.description}' />"/>
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Save">
    </form>
</div>
</body>
</html>
