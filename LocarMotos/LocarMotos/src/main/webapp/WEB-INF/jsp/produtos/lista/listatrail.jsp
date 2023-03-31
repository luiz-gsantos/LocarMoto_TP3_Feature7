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
    <h3>Lista de Motos Trail</h3>
    <c:if test="${empty trails}">
        <h5>Não há motos cadastradas.</h5>
    </c:if>
    <c:if test="${not empty trails}">
    <h5>A quantidade de motos Trail cadastradas é: ${trails.size()}!!!</h5>
</div>
<table class="container-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>seugro</th>
        <th>cilindradas</th>
        <th>ano</th>
        <th>valorVenal</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="t" items="${trails}">
        <tr>
            <td>${t.id}</td>
            <td>${t.seguro}</td>
            <td>${t.cilindradas}</td>
            <td>${t.ano}</td>
            <td>${t.valorVenal}</td>
            <td><a href="/trail/${t.id}/excluir">excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
