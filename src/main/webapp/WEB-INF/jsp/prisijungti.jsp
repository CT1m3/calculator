<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Prisijungimas</title>
        <jsp:include page="header.jsp" />
    </head>
    <body>
        <h1 class="text-center">Internetinis skaičiuotuvas</h1>
        <div class="container">
            <form method="POST" modelAttribute="userForm" class="form-signin" action="loginUser">
                <h3 class="form-heading">Prisijungimas</h3>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <input id="username", path="username" name="username" type="text" class="form-control" placeholder="Prisijungimo vardas" autofocus="true" />
                    <input id="password", path="password" name="password" type="password" class="form-control" placeholder="Slaptažodis" />
                    <span class="error-message">${errorMessage}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Prisijungti</button>
                    <h4 class="text-center"><a href="${contextPath}/registracija">Sukurti naują paskyrą</a></h4>
                </div>
            </form>
        </div>
    </body>
</html>
