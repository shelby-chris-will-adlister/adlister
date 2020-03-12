<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Contracts"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbarLogout.jsp"/>

<div class="container text-center">
    <h1 class="text-center">Available Contracts: </h1>
    <div class="container">
        <div class="row mt-5 d-flex justify-content-center">
            <c:forEach var="contract" items="${contracts}">
                <div class="col-sm-4 card card-custom mx-2 mb-3 text-center" style="">
                    <img src="img/rose.jpg" class="card-img-top" alt="..." style="width:50%; height:25%">
                    <div class="card-body">
                        <h2 class="card-title text-center"><a href="/contract?id=${contract.id}" style="color: #D10002">MISSION: ${contract.title}</a></h2>
                        <h3 class="card-text text-center">SITREP: ${contract.description}</h3>
                        <h3 class="card-text text-center">REWARD: $${contract.reward}M</h3>
                        <h3 class="card-text text-center">LOCATION: ${contract.country}</h3>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
  
    <%--    <div class="col-sm-4 card card-custom mx-2 mb-3 text-center" style="">--%>
    <%--        <img src="half-dozen.jpg" class="card-img-top" alt="...">--%>
    <%--        <div class="card-body">--%>
    <%--            <h5 class="card-title text-center">Half-Doze Roses</h5>--%>
    <%--            <p class="card-text text-center">Six Roses</p>--%>
    <%--            <a href="#" class="btn btn-primary text-center">Out Of Stock</a>--%>
    <%--        </div>--%>
    <%--    </div>--%>
</div>

</body>
</html>
