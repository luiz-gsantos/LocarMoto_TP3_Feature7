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
    <h3>Listagem de Usuários</h3>
    <c:if test="${empty cadastros}">
        <h5>Não existem usuários cadastrados!!!</h5>
    </c:if>
    <c:if test="${not empty cadastros}">
    <h5>Quantidade de usuários cadastrados: ${cadastros.size()}!!!</h5>
</div>
<table class="container-table">
    <thead>
    <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>idade</th>
                <th>CNH</th>
                <th>CPF</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${cadastros}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.nome}</td>
                    <td>${c.idade}</td>
                    <td>${c.cnh}</td>
                    <td>${c.cpf}</td>
                    <td><a href="/cadastro/${c.id}/excluir">excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>