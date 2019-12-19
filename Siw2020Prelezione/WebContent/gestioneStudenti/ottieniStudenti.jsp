<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/common.css" type="text/css" />

<link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
	<header>
		<c:if test="${studenteRegistrato != null}">
			Studente creato con successo
		</c:if>
		<h1>Elenco Studenti</h1>
	</header>
	<div class="table-responsive">
		<table class="table">
			<tr class="success">
				<th>
					Matricola
				</th>
				<th>
					Nome
				</th>
				<th>
					Cognome
				</th>
			</tr>
			<c:set var = "v" scope = "request" value = "${0}"/>
			<c:forEach items="${studenti}" var="studente">
				<c:set var = "v" scope = "request" value = "${v+1}"/>
				<c:set var = "clazz" scope = "request" value = "success"/>
				<c:if test="${v % 2 == 0}">
					<c:set var = "clazz" scope = "request" value = "default"/>
				</c:if>
				<tr class="${clazz}">
					<td>
						${studente.matricola}
					</td>
					<td>
						${studente.nome}
					</td>
					<td>
						${studente.cognome}
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>