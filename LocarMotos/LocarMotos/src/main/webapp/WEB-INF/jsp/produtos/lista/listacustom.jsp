<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="styles.css">
    <title>Index</title>
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="container-user">
    <h3>Lista de Motos Custom</h3>
    <c:if test="${empty customs}">
        <h5>Não há motos cadastradas.</h5>
    </c:if>
    <c:if test="${not empty customs}">
    <h5>A quantidade de motos Custom cadastradas é: ${customs.size()}!!!</h5>
</div>
<table class="container-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>marca</th>
        <th>modelo</th>
        <th>cilindradas</th>
        <th>seguro</th>
        <th>ano</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customs}">
        <tr>
            <td>${c.id}</td>
            <td>${c.marca}</td>
            <td>${c.modelo}</td>
            <td>${c.cilindradas}</td>
            <td>${c.seguro}</td>
            <td>${c.ano}</td>
            <td><a href="/custom/${c.id}/excluir">excluir</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
</div>
</body>
</html>
