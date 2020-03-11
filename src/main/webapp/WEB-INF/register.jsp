<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="roleId">Select Role:</label>
                <select class="form-control" id="roleId" name="roleId">
                    <option value="1">Minerva</option>
                    <option value="2">Politician</option>
                    <option value="3">Scientist</option>
                    <option value="4">Actor</option>
                    <option value="5">Mercenary</option>
                    <option value="6">Black Ops</option>
                    <option value="7">Clergy</option>
                    <option value="8">Grunt</option>
                    <option value="9">Hacker</option>
                    <option value="10">Banker</option>
                </select>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>
