<%@page import="ppi.agenda.dao.CarrosDao"%>
<%@page import="ppi.agenda.dao.*"%>
<%@page import="ppi.agenda.model.Carro"%>
<%@page import="ppi.agenda.model.Carro"%>
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


	<%@include file="cabecalho.jsp"%>



	<div id="main" class="container-fluid">

		<h3 class="page-header text-center">Dados Pessoais</h3>

		<form action="ControllerServlet" method='get'>


			<div class="container">
				<div class="form-group col-md-8 col-md-offset-2">
					<label for="nome">Nome *</label> <input type="text"
						class="form-control" id="nome" name="nome" />
				</div>

				<div class="form-group col-md-3 col-md-offset-2">
					<label for="cpf">CPF *</label> <input type="number"
						class="form-control" id="cpf" name="cpf" />
				</div>

				<div class="form-group col-md-3 col-md-offset-2">
					<label for="cpf">Data nascimento *</label> <input type="text"
						class="form-control" id="dataNascimento" name="dataNascimento" />
				</div>


				<div class="form-group col-md-4">
					<label for="telefone">Telefone</label> <input type="number"
						class="form-control" id="telefone" name="telefone" />
				</div>



				<div class="form-group col-md-4 col-md-offset-2">
					<label for="endereco">Endereço</label> <input type="text"
						class="form-control" id="endereco" name="endereco" />
				</div>



				<div class="form-group col-md-4">
					<label for="email">Email</label> <input type="email"
						class="form-control" id="email" name="email" />
				</div>


				<div class="form-group col-md-6 col-md-offset-2">
					<label for="">* campos obrigatórios</label>

				</div>


				<div class="form-group col-md-6 col-md-offset-6">
					<h2>Selecionar carro</h2>

				</div>


				<input type="hidden" name="logica" value="AlugarCarro" />



				<%
					String[] dados = (String[]) request.getAttribute("dados");
				%>


				<input type="hidden" name="dataretirada" value="<%=dados[0]%>" /><br />
				<input type="hidden" name="horaretirada" value="<%=dados[1]%>" /><br />
				<input type="hidden" name="datadevolucao" value="<%=dados[2]%>" /><br />
				<input type="hidden" name="horadevolucao" value="<%=dados[3]%>" /><br />

				<br> <br>


				<div class="col-md-offset-2">
					<div class="table-responsive">


						<table class="table table-sm">
							<thead class="thead-inverse">
								<tr>
									<th>#</th>
									<th>Categoria</th>
									<th>Fabricacao</th>
									<th>Selecionar carro</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="carro" items="${carros}">

									<tr>
										<td>${carro.id}</td>
										<td>${carro.modelo}</td>

										<td>${carro.categoria}</td>
										<td>
											<div class="form-check">
												<label class="form-check-label"> <input
													class="form-check-input" type="checkbox" name="carro"
													value=${carro.id } aria-label="...">
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
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="template.html" class="btn btn-default">Cancelar</a>
				</div>

			</div>
		</form>
	</div>


</body>
</html>