<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Segreteria</title>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<LINK rel="stylesheet" href="css/index.css" type="text/css">

</head>
<body>

<header>
	<aside>	
		<figure>
			<a href="http://www.unical.it">
				<img src="images/logo_unical.png" width="300"/>
			</a>			
		</figure>
	</aside>
	<aside>
	<nav class="navbar">
		<ul class="nav navbar-nav">
			<li class="nav-item"><a class="dropdown-item" href="">Chi siamo</a></li></li>
			<li class="nav-item"><a class="dropdown-item" href="">Contattaci</a></li></li>
			<li class="nav-item">
				<c:if test="${utente != null}">
					<p>Sei loggato come ${utente.username}</p>
					<a class="dropdown-item" href="login?logout=true">Logout</a>
				</c:if>
				<c:if test="${utente == null}">
					<a class="dropdown-item" href="login">Login</a>
				</c:if>	
			</li></li>
		</ul>
	</nav>
	</aside>
	<figure>
		<a href="images/segreteria.jpg">
			<img src="images/segreteria.jpg" width="200"/>
		</a>
		<figcaption>La nostra segreteria studenti</figcaption>
	</figure>	
	<div>
		<h2>Portale segreteria studenti</h2>
		<h3>Portale gestione segreteria studenti</h3>
	</div>	
</header>

<h2>
	Benvenuti nel portale di gestione delle Segreterie Studenti
</h2>
<p>
	Utilizza il menu in alto per 
	<strong>
		navigare tra le <i>varie</i> sezioni della <u>pagina</u>
	</strong>
</p>
<p>
	Ti auguriamo una felice navigazione
</p>
<section>
	<nav class="navbar navbar-inverse">
		<ul class="nav navbar-nav">
			<li class="nav-item"><a class="dropdown-item" href="">Home</a></li></li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Studenti</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="gestioneStudenti/ottieniStudenti">Elenco Studenti</a></li>			
					<li><a class="dropdown-item" href="gestioneStudenti/iscriviStudenti">Iscrivi uno studente</a></li>
					<li><a class="dropdown-item" href="servizi/isee.html">Calcolo ISEE</a></li>					
				</ul>
			</li>
			<li class="nav-item"><a class="dropdown-item" href="">Corsi</a></li></li>
			<li class="nav-item"><a class="dropdown-item" href="">Corsi di Laurea</a></li></li>
			<li class="nav-item"><a class="dropdown-item" href="">Dipartimenti</a></li></li>
		</ul>
	</nav>
</section>


	
<section class="row">	
	<article class="col-sm-4 col-xs-12 jumbotron">
		<header><h3>Dicono di noi</h3></header>
		La segreteria � un servizio di riferimento che serve per...
	</article>	
	<div class="col-sm-2 col-xs-0"></div>
	<article class="col-sm-4 col-xs-12 jumbotron" >
		<header><h3>Centro ICT di Ateneo</h3></header>
		Dalla pagine accessibile da <a href="http://www.unical.it">questo link</a>	
	</article> 
</section>

<footer>
	<a href="http://www.unical.it">
		Clicca qui per accedere al sito dell'unical
	</a>
</footer>

</body>
</html>