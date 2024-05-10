<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!-- compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jqusery.min.js"></script>

<!-- compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="http://localhost:8080/">Skaičiuotuvas</a>
        </div>
        <ul class="nav navbar-nav navbar-left">
            <li class="active"><a href="/skaiciai">Atliktos operacijos</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a>Vartotojas: <span style="color: green">${pageContext.request.userPrincipal.name}</span></a></li>
            <li><a><span style="color: blue">${role}</span></a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Atsijungti</a></li>
        </ul>
    </div>
</nav>
