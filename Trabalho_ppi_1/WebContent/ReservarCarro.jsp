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

<script>
	$(function() {
		$("#calendario").datepicker(
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
  $(function()){
	  alert("awuo");

	  $("#msg"){
		  alert("awuo");
			var opc = document.getElementById("msg").value;
			
			if(msg == "erro"){
				alert("erross")
			}

	  }
  }

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
	function optionChange() {
		var opc = document.getElementById("combo").value;
		var cat;

		if (opc == 'e') {

			document.getElementById("tarifa").value = 70;
			cat = "economico";

		} else if (opc == 'i') {
			document.getElementById("tarifa").value = 90;
			cat = "intermediario";

		} else if (opc == 's') {
			document.getElementById("tarifa").value = 120
			cat = "suv";
		} else {
			document.getElementById("tarifa").value = 150;
			cat = "executivo";

		}

		return cat;
	}
</script>







</head>
<body>

	<%@include file="cabecalho.jsp"%>





	<div id="main" class="container-fluid">  
	
		<br>
		<br>
		
				<p class="bg-warning text-center"> <strong> ${msg } </strong> </p>
		

		<h3 class="page-header text-center">Reservar Carro</h3>

		<form action="ControllerServlet" method="post">
			
			<fieldset>
		
			<div class="container">
				<div class="form-group col-md-6">
					<label for="datare">Data de retirada</label> <input type="text"
						class="form-control" id="calendario" name="dataretirada" required />
				</div>


				<div class="form-group col-md-6">
					<label for="exampleInputEmail1">Horário de retirada</label> <input
						type="text" class="form-control" id="horaretirada"
						name="horaretirada" placeholder="22:00">
				</div>


				<div class="form-group col-md-6">
					<label for="exampleInputEmail1">Data de devolução</label> <input
						type="text" class="form-control" name="datadevolucao"
						id="datadevolucao">
				</div>


				<div class="form-group col-md-6">
					<label for="exampleInputEmail1">Horário de devolução</label> <input
						type="text" class="form-control" name="horadevolucao"
						id="horadevolucao" name=placeholder="22:00">
				</div>



				<div class="form-group col-md-6">
					<label for="">Tipo de carro</label> <select class="form-control"
						id="combo " name="combo" id="combo">
						<option> Selecione o tipo </option>
						<option value="economico">Econômico</option>
						<option value="intermediario">Intermediário</option>
						<option value="suv">SUV</option>
						<option value="executivo">Executivo</option>
					</select>
				</div>


				<input type="hidden" name="logica" value="DadosReserva" />

				<div class="col-md-12">
					<br> <br>
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="template.html" class="btn btn-default">Cancelar</a>
				</div>
			</div>

</fieldset>


		</form>
	</div>  


	<script src="js/bootstrap.min.js"></script>
</body>
</html>