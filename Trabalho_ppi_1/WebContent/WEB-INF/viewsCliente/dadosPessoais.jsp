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

		<h3 class="page-header text-center">Dados Pessoais</h3>
		
		<br>
		<h2 class="text-center "> ${msg } </h2>
		<br>

		<form action="ControllerServlet" method='post'>


			<%
				Cliente cl = (Cliente) request.getSession(false).getAttribute("cliente");
			%>


			<div class="container">



				<div class="form-group col-md-8 col-md-offset-2">
					<label for="nome">ID</label> <input type="text"
						class="form-control" id="nome" name="id" value=<%=cl.getId()%>
						readonly />
				</div>
				<div class="form-group col-md-8 col-md-offset-2">
					<label for="nome">Nome *</label> <input type="text"
						class="form-control" id="nome" name="nome" value=<%=cl.getNome()%>
						required />
				</div>

				<div class="form-group col-md-3 col-md-offset-2">
					<label for="cpf">CPF *</label> <input type="number"
						class="form-control" id="cpf" name="cpf" value=<%=cl.getCpf()%>
						required />
				</div>

				<div class="form-group col-md-3 col-md-offset-2">
					<label for="cpf">Data nascimento </label> <input type="text"
						class="form-control" id="dataNascimento" name="dataNascimento"
						value=<%=cl.getDataNascimentoString()%> />
				</div>


				<div class="form-group col-md-4">
					<label for="telefone">Telefone</label> <input type="number"
						class="form-control" id="telefone" name="telefone"
						value=<%=cl.getTelefone()%> required />
				</div>



				<div class="form-group col-md-4 col-md-offset-2">
					<label for="endereco">Endereço</label> <input type="text"
						class="form-control" id="endereco" name="endereco"
						value=<%=cl.getEndereco()%> required />
				</div>



				<div class="form-group col-md-4">
					<label for="email">Email</label> <input type="email"
						class="form-control" id="email" name="email"
						value="<%=cl.getEmail()%>" />
				</div>




				<div class="form-group col-md-6 col-md-offset-2">
					<label for="">* campos obrigatórios</label> <input type="hidden"
						name="logica" value="AlterarCliente" /> <input type="hidden" name="tipo"
						value="1" />



				<div class="form-group col-md-6 col-md-offset-2">
						<br>
						<button type="submit" class="btn btn-primary">Salvar
							Alterações</button>
					   </div>
					   <a href="ControllerServlet?logica=AlterarCliente&tipo=2&id=<%=cl.getId()%>"> Excluir conta</a>

				</div>
			</div>
		</form>
	</div>

	<script src="js/bootstrap.min.js"></script>
</body>
</html>