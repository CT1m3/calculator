<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Skaiciaus atnaujinimas</title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>
        <form:form name="skaicius" action="atnaujintiSkaiciu" method="post">
            <input type="hidden"    name="id"   value="${skaicius.id}"><p>
            pirmas skaicius:<br>
            <input type="number"    name="num1"  value="${skaicius.num1}"><p>
            Ženklas:<br>
            <input type="text"  name="operation"  value="${skaicius.operation}"><p>
            Antras skaičius:<br>
            <input type="number"    name="num2"  value="${skaicius.num2}"><p>
            Rezultatas:<br>
            <input type="number"    name="result"   value="${skaicius.result}"><p>
            <input type="submit" value="Atnaujinti">
        </form:form>
    </body>
</html>