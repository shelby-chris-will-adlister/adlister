<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!"/>
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container d-flex justify-content-center">
    <div class="row">
        <div class="d-flex justify-content-center">
            <h1 class="text-center">Welcome to the SCS! </h1>
        </div>
    </div>
    <div class="container">
        <div class="row mt-5 d-flex justify-content-center">
                <div class="col-sm-4 card card-custom mx-2 mb-3 text-center" style="">
                    <img src="img/half-dozen.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title text-center">Half-Doze Roses</h5>
                        <p class="card-text text-center">Six Roses</p>
                        <a href="#" class="btn btn-primary text-center">Out Of Stock</a>
                    </div>
                </div>
                <div class="col-sm-4 card card-custom mx-2 mb-3 text-center" style="">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Half-Doze Roses</h5>
                        <p class="card-text">Six Roses</p>
                        <a href="#" class="btn btn-primary">Out Of Stock</a>
                    </div>
                </div>
                <div class="col-sm-4 card card-custom mx-2 mb-3 text-center" style="">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Half-Doze Roses</h5>
                        <p class="card-text">Six Roses</p>
                        <a href="#" class="btn btn-primary">Out Of Stock</a>
                    </div>
                </div>
        </div>
    </div>
</div>

<%--//bootstrap scripts--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
</body>
</html>
