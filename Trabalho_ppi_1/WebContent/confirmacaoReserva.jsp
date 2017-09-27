<%@page import="ppi.locadora.model.Cliente"%>
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
<title>Locadora de Carro</title>

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
<body>

	<%@include file="cabecalhoCliente.jsp"%>

	<div class="container">

		<br>
		<div class="form-group col-md-2 offset-md-2">
			<label for="exampleInputEmail1">ID do aluguel</label> <input
				type="text" class="form-control" value=${result[0] } readonly />
		</div>


		<div class="form-group col-md-2 offset-md-2">
			<label for="exampleInputEmail1"> Data de Início</label> <input
				class="form-control" value="${result[1]}" readonly />
		</div>

		<div class="form-group col-md-2 offset-md-2">
			<label for="exampleInputEmail1"> Data de Entrega</label> <input
				class="form-control" value="${result[2]}" readonly />
		</div>

		<div class="form-group col-md-2 offset-md-2">
			<label for="exampleInputEmail1"> Tarifa por dia</label> <input
				class="form-control" value="${result[3]}" readonly />
		</div>

		<div class="form-group col-md-2 offset-md-2">
			<label for="exampleInputEmail1"> Total a ser pago na
				devolução</label> <input class="form-control" value="${result[4] }" readonly />
		</div>

		<div class="form-group col-md-2 offset-md-2">
			<label for="exampleInputEmail1"> Multa por dia de atraso </label> <input
				class="form-control" value="${result[5] }" readonly />
		</div>


	</div>
</body>
</html>