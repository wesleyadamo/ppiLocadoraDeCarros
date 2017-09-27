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


	<%@include file="cabecalhoFuncionario.jsp"%>

	<div id="main" class="container-fluid">
		<br> <br>

		<h3 class="page-header text-center">Reservas Realizadas</h3>

		<br>

		<div class="col-md-offset-2">
			<div class="table-responsive">


				<table class="table table-sm">
					<thead class="thead-inverse">
						<tr>
							<th>#</th>
							<th>ID Cliente</th>
							<th>ID Carro</th>
							<th>Data inicial</th>
							<th>Data Final</th>
							<th>Tarifa base</th>
							<th>Devolução</th>


						</tr>
					</thead>
					<tbody>

						<c:forEach var="reservas" items="${reservas}">

							<tr>
								<td>${reservas.id}</td>
								<td>${reservas.idDoCliente}</td>
								<td>${reservas.renavanDoCarro}</td>
								<td>${reservas.dataInicioAluguelString}</td>
								<td>${reservas.dataFinalAluguelString}</td>
								<td>${reservas.tarifaBase}</td>
								<td>
									<form action="ControllerServlet">
										<input type="hidden" value=${reservas.id } name="idReserva" />
													<input type="hidden" name="idCliente" value=${reservas.idDoCliente } />
										
										<input type="hidden" value="Devolucao" name="logica" />
										<button type="submit" class="btn btn-primary">Devolução</button>
									</form>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>
</html>