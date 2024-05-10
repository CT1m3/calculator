<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/calculator">Skaičiuotuvas</a>
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
