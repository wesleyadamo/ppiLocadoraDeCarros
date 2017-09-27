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

<script>
	$(function() {
		$("#dataretirada").datepicker(
				{
					
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta',
							'Quinta', 'Sexta', 'Sábado', 'Domingo' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'Sáb', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
							'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
							'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ]
				});
	});
</script>


<script>
	$(function() {
		$("#datadevolucao").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta',
							'Quinta', 'Sexta', 'Sábado', 'Domingo' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'Sáb', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
							'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
							'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ]
				});
	});
</script>

<script>
	function optionCheck() {

		var opc = document.getElementById("combo").value;
		
		alert(opc);

		if (opc == 'economico') {
			document.getElementById("tarifa").value = 70;

		} else if (opc == 'intermediario') {
			document.getElementById("tarifa").value = 90;
			alert("aqui i");

		} else if (opc == 'suv') {
			document.getElementById("tarifa").value = 120
		} else {
			document.getElementById("tarifa").value = 150;

		}

	}
</script>


</head>
<body>

	<%@include file="cabecalhoCliente.jsp"%>

	<div id="main" class="container-fluid">

		<br> 

		<p class="bg-warning text-center">
			<strong> ${msg } </strong>
		</p>


		<h3 class="page-header text-center">Reservar Carro</h3>

		<form action="ControllerServlet" method="get">


			<div class="container">
				<div class="form-group col-md-6 offset-md-2">
					<label for="datare">Data de retirada</label> <input type="text"
						class="form-control" id="dataretirada" name="dataretirada" required placeholder="28/09/2017" />
				</div>


				<div class="form-group col-md-6 offset-md-2">
					<label for="exampleInputEmail1">Horário de retirada</label> <input
						type="text" class="form-control" id="horaretirada"
						name="horaretirada" placeholder="22:00" required>
				</div>


				<div class="form-group col-md-6 offset-md-2">
					<label for="exampleInputEmail1">Data de devolução</label> <input
						type="text" class="form-control" name="datadevolucao"
						id="datadevolucao" placeholder="10/10/2017" required>
				</div>


				<div class="form-group col-md-6 offset-md-2">
					<label for="exampleInputEmail1">Horário de devolução</label> <input
						type="text" class="form-control" name="horadevolucao"
						id="horadevolucao" name="horadevolucao" placeholder="22:00" required>
				</div>



				<div class="col-md-6 offset-md-2">
					<label for="">Tipo de carro</label> <select class="form-control"
						 name="combo" id="combo"  onchange="optionCheck()">
						<option value="economico">Econômico (70 reais dia)</option>
						<option value="intermediario">Intermediário (90 reais dia)</option>
						<option value="suv">SUV (120 reais dia)</option>
						<option value="executivo">Executivo (150 reais dia)</option>
					</select>
					
					
				</div>
				
				<br> <input type="hidden" name="logica" value="DadosReserva" />
				
				<input type="hidden" name="tarifa" id="tarifa" value="70" />


				<div class="col-md-12 offset-md-2">
					
					<button type="submit" class="btn btn-primary">Prosseguir</button>

				</div>
			</div>



		</form>
	</div>


	<script src="js/bootstrap.min.js"></script>
</body>
</html>