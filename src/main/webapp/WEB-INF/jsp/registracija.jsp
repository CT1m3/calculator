<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Registracija</title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>
        <div class="container">
            <form:form method="POST" modelAttribute="userForm" class="form-signin">
                <h2 class="form-signin-heading">Naujos paskyros sukūrimas</h2>
                <spring:bind path="email">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="email" class="form-control" placeholder="Email" autofocus="true"/>
                        <form:errors path="email"/>
                    </div>
                </spring:bind>
                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="password" class="form-control" placeholder="Slaptažodis"/>
                        <form:errors path="password"/>
                    </div>
                </spring:bind>
                <spring:bind path="cnfPassword">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="password" path="cnfPassword" class="form-control" placeholder="Slaptažodžio patvirtinimas"/>
                        <form:errors path="cnfPassword"/>
                    </div>
                </spring:bind>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sukurti</button>
            </form:form>
        </div>
    </body>
</html>