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
        <h2><a href="/contracts" style="color: #D10002 !important;">View Available Contracts</a></h2>
    </div>

    <div class="container text-center">
        <h1 class="text-center">Contracts You've Created: </h1>
        <div class="container">
            <div class="row mt-5 d-flex justify-content-center">
                <c:forEach var="contract" items="${contracts}">
                    <div class="col-sm-4 card card-custom mx-2 mb-3 text-center" style="">
                        <img src="img/rose.jpg" class="card-img-top" alt="..." style="width:50%; height:25%">
                        <div class="card-body">
                            <h2 class="card-title text-center">MISSION: ${contract.title}</h2>
                            <p class="card-text text-center">SITREP: ${contract.description}</p>
                            <p class="card-text text-center">REWARD: $${contract.reward}M</p>
                            <p class="card-text text-center">LOCATION: ${contract.country}</p>
                            <form action="/contracts/edit" method="GET">
                                <div class="form-group">
                                    <input type="hidden" name="id" value="${contract.id}">
                                    <button type="submit" class="btn text-center" style="background-color: #D10002 !important; color: white"><i class="icon-edit"></i>Edit</button>
                                </div>
                            </form>
                            <form action="/contracts/delete" method="POST">
                                <div class="form-group">
                                    <input type="hidden" name="id" value="${contract.id}">
                                    <button type="submit" class="btn text-center" style="background-color: #D10002 !important; color: white"><i class="icon-delete"></i>Delete</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="containter">
            <h1 class="text-center">Create A New Contract: </h1>
            <div class="form-group">
                <form action="/contracts/create" method="GET">
                    <button type="submit" class="btn text-center" style="background-color: #D10002 !important; color: white"><i class="icon-edit"></i>CREATE</button>
                </form>
            </div>
        </div>
    </div>
  
</body>
</html>
