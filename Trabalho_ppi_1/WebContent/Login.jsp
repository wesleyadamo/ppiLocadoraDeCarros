<%@page import="ppi.agenda.DAO.ContatoDAO"%>
<%@page import="ppi.agenda.model.Contato"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CRUD com Bootstrap 3</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">


<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
	integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
	integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
	integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
	crossorigin="anonymous"></script>


<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>

	<%@include file="cabecalho.jsp"%>


	<div id="main" class="container-fluid">

		<br> <br>

		<p class="bg-warning text-center">
			<strong> ${msg } </strong>
		</p>


		<h3 class="page-header text-center">Login</h3>

		<form action="ControllerServlet" method="post">


			<div class="container">
				<div class="form-group col-md-3 col-md-offset-4">
					<label for="id">ID</label> <input type="number"
						class="form-control" name="id" required />
				</div>


				<div class="form-group col-md-3 col-md-offset-3">
					<label for="exampleInputEmail1">CPF</label> <input type="text"
						class="form-control" name="cpf">
				</div>


				<div class="form-group col-md-4 col-md-offset-2"></div>


				<input type="hidden" name="logica" value="Login" /> <input
					type="hidden" name="tipo" value="1" />


				<div class="col-md-12">
					<br>
					<button type="submit" class="btn btn-primary">Prosseguir</button>

					<a href="criarConta.jsp"> Criar Conta</a>

				</div>
			</div>



		</form>
	</div>


	<script src="js/bootstrap.min.js"></script>
</body>
</html>