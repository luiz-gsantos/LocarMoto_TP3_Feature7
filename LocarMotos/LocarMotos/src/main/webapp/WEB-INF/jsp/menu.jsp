<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<div class="navbar-container">
		<div >
			<a class="navbar-title" href="/">LocarMoto</a>
		</div>
		<div>
			<ul class="navbar-lista">
				<c:if test="${not empty usuario}">
				<li><div class="dropdown">Custom<div class="dropdown-content"><a href="/custom">Cadastro</a><br><br><a href="listacustom">Lista</a></div></div></li>
				<li><div class="dropdown">Trail<div class="dropdown-content"><a href="/trail">Cadastro</a><br><br><a href="listatrail">Lista</a></div></div></li>
				<li><div class="dropdown">Street<div class="dropdown-content"><a href="/street">Cadastro</a><br><br><a href="listastreet">Lista</a></div></div></li>
				<li><div class="dropdown">Motocicleta<div class="dropdown-content"><a href="/listamotocicleta">Lista</a></div></div></li>
				<li><div class="dropdown">Cadastro<div class="dropdown-content"><a href="/cadastro">Cadastro</a><br><br><a href="/listacadastro">Lista</a></div></div></li>
				<li><div class="dropdown">Usuario<div class="dropdown-content"><a href="usuario">Cadastro</a><br><br><a href="/lista">Lista</a></div></div></li>
				</c:if>
			</ul>
		</div>
		<div>
			<ul class="menu-right">
				<c:if test="${empty usuario}">
				<li><a href="/login">Entrar</a></li>
				<li><a href="/usuario">Cadastrar</a></li>
				</c:if>
				<c:if test="${not empty usuario}">
					<li><a href="/logout"> Logout, ${usuario.nome}</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</header>
