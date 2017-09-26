
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CRUD com Bootstrap 3</title>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>


<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">


<!--  fun��o para selecionar a op��o assim que a p�gina � carregada -->
<script>
	$(document).ready(function() {
		var valor = document.getElementById("select").value;

		var combo = document.getElementById("combo");

		for (var i = 0; i < combo.options.length; i++) {

			if (combo.options[i].value == valor) {

				combo.options[i].selected = "true";
				break;
			}
		}

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

		} else if (opc == 'suv') {
			document.getElementById("tarifa").value = 120
		} else {
			document.getElementById("tarifa").value = 150;

		}

	}
</script>
</head>
<body>


	<%@include file="cabecalhoFuncionario.jsp"%>



	<div id="main" class="container-fluid">
		<br>
		<h3 class="page-header text-center">Editar carro</h3>

		<form action="ControllerServlet">
			<div class="container">


				<div class="form-group col-md-5 col-md-offset-4">
					<label for="exampleInputEmail1">Modelo *</label> <input type="text"
						class="form-control" name="modelo" required value="${param.modelo }" />
				</div>


				<div class="form-group col-md-2 col-md-offset-4">
					<label for="exampleInputEmail1">Ano de fabrica��o *</label> <input
						type="number" class="form-control" name="anofabricacao" required
						value="${param.ano }" />
				</div>


				<div class="form-group col-md-3">
					<label for="exampleInputEmail1">Renavan </label> <input
						type="number" class="form-control" name="renavan" required
						value="${param.renavan }" />
				</div>


				<input type="hidden" id="select" name="select"
					value="${param.categoria }" />

				<div class="form-group col-md-3 col-md-offset-4">

					<label for="">Categoria</label> <select class="form-control"
						id="combo" name="combo" onchange="optionCheck()">
						<option> Selecione o tipo </option>
						<option value="economico">Econ�mico</option>
						<option value="intermediario">Intermedi�rio</option>
						<option value="suv">SUV</option>
						<option value="executivo">Executivo</option>
					</select>
				</div>

				<div class="form-group col-md-2 id ="divtarifa" >
					<label for="exampleInputEmail1">Tarifa dia </label> <input
						type="text" class="form-control" id="tarifa" name="tarifa"
						value="${param.tarifa }" readonly />
				</div>


				<div class="col-md-2 col-md-offset-4">
					<label for="">* campos obrigat�rios</label>
				</div>

				<input type="hidden" name="logica" value="AlterarCarro" />

				<div class="col-md-12 col-md-offset-4">
					<br> <br>
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="template.html" class="btn btn-default">Cancelar</a>
				</div>
			</div>




		</form>
	</div>






	<script src="js/bootstrap.min.js"></script>
</body>
</html>