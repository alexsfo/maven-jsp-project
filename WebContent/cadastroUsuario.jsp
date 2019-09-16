<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<link href="resources/css/cadastro.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>

</head>

<body>

	<h1>Cadastros Usuários</h1>

	<form action="salvarUsuario" method="post">
		<ul class="form-style-1">
			<li>
				<table>
					<tr>
						<td>Código:</td>
						<Td><input type="text" id="id" name="id"></Td>
					</tr>
					<tr>
						<td>Nome:</td>
						<Td><input type="text" id="nome" name="nome" value="${user.nome }"></Td>
					</tr>
					<tr>
						<td>Email:</td>
						<Td><input type="text" id="email" name="email"></Td>
					</tr>


					<tr>
						<td>Telefone:</td>
						<Td><input type="text" id="id" name="id"></Td>
					</tr>

					<tr>
						<td>Celular:</td>
						<Td><input type="text" id="id" name="id"></Td>
					</tr>



					<tr>

						<td></td>
						<td><input type="submit" value="Salvar"></td>

					</tr>


				</table>
		</ul>
	</form>

	<div class="container">
		<table class="responsive-table">
			<caption>Cadastros</caption>
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Email</th>
					<th scope="col">Senha</th>
					<th scope="col">telefone</th>
					<th scope="col">Editar</th>
					<th scope="col">Excluir</th>
				</tr>
			</thead>

			<c:forEach items="${usuarios}" var="user">
				<tr>
					<td style="width: 100px"><c:out value="${user.id}">
						</c:out></td>
					<td style="width: 250px"><c:out value="${user.nome}">
						</c:out></td>

					<td><c:out value="${user.email}">
						</c:out></td>

					<td><c:out value="${user.senha}">
						</c:out></td>

					<td><c:out value="${user.id}">
						</c:out></td>


					<td><a href="salvarUsuario?acao=editar&user==${user.nome}"><img
							src="resources/img/edit.png" title="Editar" width="20px"
							height="20px"></a></td>

					<td><a href="salvarUsuario?acao=delete&user=${user.nome}"></a><img
						src="resources/img/delete.png" title="Excluir" width="20px"
						height="20px"></td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>