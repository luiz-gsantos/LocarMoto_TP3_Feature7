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
    <c:if test="${empty usuarios}">
        <h5>Não existem usuários cadastrados!!!</h5>
    </c:if>
    <c:if test="${not empty usuarios}">
    <h5>Quantidade de usuários cadastrados: ${usuarios.size()}!!!</h5>
</div>
<table class="container-table">
    <thead>
    <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Senha</th>
                <th>E-mail</th>
                <th>CNH</th>
                <th>CPF</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="u" items="${usuarios}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.nome}</td>
                    <td>${u.senha}</td>
                    <td>${u.email}</td>
                    <td>${u.cnh}</td>
                    <td>${u.cpf}</td>
                    <td><a href="/usuario/${u.id}/excluir">excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>