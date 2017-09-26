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

		<h3 class="page-header text-center">Dados do Aluguel</h3>

		<br>

		<div class="container">
			<div class="form-group col-md-6">
				<label for="datare">Id</label> <input type="text"
					class="form-control" name="idReserva" value=${aluguel.id } readonly />
			</div>


			<div class="form-group col-md-2">
				<label for="datare">Modelo do carro</label> <input type="text"
					class="form-control" name="modeloCarro"
					value="${aluguel.modeloDoCarro }" readonly />
			</div>



			<div class="form-group col-md-6">
				<label for="exampleInputEmail1">ID Cliente</label> <input
					type="text" class="form-control" id="horaretirada" name="idCliente"
					value="${aluguel.idDoCliente }" readonly>
			</div>


			<div class="form-group col-md-6">
				<label for="exampleInputEmail1">Renavan do Caro</label> <input
					type="text" class="form-control" name="renavanCarro"
					value="${aluguel.renavanDoCarro }" readonly>
			</div>


			<div class="form-group col-md-6">
				<label for="exampleInputEmail1">Inicío do ALuguel</label> <input
					type="text" class="form-control" name="dataInicio"
					value="${aluguel.dataInicioAluguelString }" readonly>
			</div>

			<div class="form-group col-md-6">
				<label for="exampleInputEmail1">Data de entrega</label> <input
					type="text" class="form-control" name="dataDevolucao"
					value="${aluguel.dataFinalAluguelString }" readonly>
			</div>

			<div class="form-group col-md-6">
				<label for="exampleInputEmail1">Cliente</label> <input type="text"
					class="form-control" name="cliente" value="${aluguel.nomeCliente }"
					readonly>
			</div>

			<div class="form-group col-md-6">
				<label for="exampleInputEmail1">CPF do cliente</label> <input
					type="text" class="form-control" name="cpfCliente"
					value="${aluguel.cpfCliente }" readonly>
			</div>


			<div class="form-group col-md-6">
				<label for="exampleInputEmail1">Tarifa dia</label> <input
					type="text" class="form-control" name="valorTotal"
					value=${aluguel.tarifaBase } readonly>
			</div>


			<div class="form-group col-md-6">
				<label for="exampleInputEmail1">Valor total a pagar</label> <input
					type="text" class="form-control" name="valorTotal"
					value="${aluguel.tarifaFinal }" readonly>
			</div>
			
			<form>
			
			<input type="hidden" name="idReserva" value=${aluguel.id } />
			<input type="hidden" name="logica" value="ConfirmacaoDevolucao" />
			<div class="col-md-12">
					<br> <br>
					<button type="submit" class="btn btn-primary">Confirmar</button>

				</div>
				
		</form>



</div>

		</div>
</body>
</html>