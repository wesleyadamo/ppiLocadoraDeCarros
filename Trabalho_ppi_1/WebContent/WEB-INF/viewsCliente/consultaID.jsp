<%@page import="ppi.locadora.model.*"%>
<%@page import="ppi.locadora.dao.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Locadora de carros</title>


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


	<%@include file="cabecalhoCliente.jsp"%>



	<div id="main" class="container-fluid">

		<br>
		<h3 class="page-header text-center">Consulta de reserva</h3>

		<form action="ControllerServlet" method="get">

			<input type="hidden" value="ListarReservas" name="logica">

			<div class="col-md-4 col-md-offset-6">
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="Pesquisar por código de reserva" required name="id">
					<span class="input-group-btn">
						<button class="btn btn-default" type="submit">Pesquisar!</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
		</form>

      ${msg}
		<div class="table-responsive">
			<table class="table">
				<thead class="thead-inverse">
					<tr>
						<th>#</th>
						<th>Modelo do carro</th>
						<th>Renavan</th>
						<th>Modelo do carro</th>
						<th>Início</th>
						<th>Fim</th>
						<th>Cliente</th>
						<th>CPF</th>
						<th>Tarifa dia</th>


					</tr>

				</thead>

				<tbody>

<% Aluguel reserva = (Aluguel) request.getAttribute("result");
    if(reserva !=null){
    	
    
%>

						<tr>
							 <td><%= reserva.getId() %></td>
							<td><%= reserva.getModeloDoCarro() %></td>
							<td><%= reserva.getIdDoCliente() %></td>
							<td><%= reserva.getRenavanDoCarro() %></td>
							<td><%= reserva.getDataInicioAluguelString() %></td>
							<td><%= reserva.getDataFinalAluguelString() %></td>
							<td><%= reserva.getNomeCliente() %></td>
							<td><%= reserva.getCpfCliente() %></td>
							<td><%= reserva.getTarifaBase() %></td> 
														


						</tr>
						
						<% } %>

				</tbody>
			</table>
		</div>


	</div>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>