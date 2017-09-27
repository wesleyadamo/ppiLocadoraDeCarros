<%@page import="ppi.locadora.dao.*"%>
<%@page import="ppi.locadora.model.*"%>

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
		<br> <br>

		<h3 class="page-header text-center">Escolha do carro</h3>

		<form action="ControllerServlet" method='post'>


			<input type="hidden" name="logica" value="AlugarCarro" />

			<%
				String[] dados = (String[]) request.getAttribute("dados");
				//Cliente cl = (Cliente) request.getAttribute("cliente");*/
			%>

			
				<input type="hidden" name="dataretirada" value="<%=dados[0]%>" /><input
				type="hidden" name="horaretirada" value="<%=dados[1]%>" /><br /> <input
				type="hidden" name="datadevolucao" value="<%=dados[2]%>" />
			<input type="hidden" name="horadevolucao" value="<%=dados[3]%>" />

			<div class="col-md-offset-2">
				<div class="table-responsive">


					<table class="table table-sm">
						<thead class="thead-inverse">
							<tr>
								<th>Renavam</th>
								<th>Modelo</th>
								<th>Fabricacao</th>
								<th>Tafira dia </th>
								<th>Período</th>
								<th>Valor a pagar</th>
								<th>Selecionar carro</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="carro" items="${carros}">

								<tr>
									<td>${carro.renavan}</td>
									<td>${carro.modelo}</td>
									<td>${carro.anoFabricacao}</td>
									<td>${carro.tarifaDia }</td>
									<td> ${dados[5] } dias </td>
								    <td>${dados[6] }</td>
									
									
									<td>
										<div class="form-check">
											<label class="form-check-label"> <input
												class="form-check-input" type="checkbox" name="carro"
												value=${carro.renavan } aria-label="...">
											</label>



										</div>

									</td>


								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>




			<div class="col-md-12 col-md-offset-2">
				<br> <br>
				<button type="submit" class="btn btn-primary">Confirmar</button>
				<a href="ReservarCarro.jsp" class="btn btn-default">Cancelar</a>
			</div>
		</form>

	</div>


</body>
</html>