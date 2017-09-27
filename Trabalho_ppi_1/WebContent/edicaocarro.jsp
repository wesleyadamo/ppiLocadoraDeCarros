
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Locadora de carro</title>

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



<!--  função para selecionar a opção assim que a página é carregada -->
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


<!--  funcção para quando muda o select  -->
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
						class="form-control" name="modelo" required value="${carro.modelo }" />
				</div>


				<div class="form-group col-md-2 col-md-offset-4">
					<label for="exampleInputEmail1">Ano de fabricação *</label> <input
						type="number" class="form-control" name="anofabricacao" required
						value="${carro.anoFabricacao }" />
				</div>


				<div class="form-group col-md-3">
					<label for="exampleInputEmail1">Renavan </label> <input
						type="number" class="form-control" name="renavan" required
						value="${carro.renavan }" />
				</div>


				<input type="hidden" id="select" name="select"
					value="${carro.categoria }" />

				<div class="form-group col-md-3 col-md-offset-4">

					<label for="">Categoria</label> <select class="form-control"
						id="combo" name="combo" onchange="optionCheck()">
						<option> Selecione o tipo </option>
						<option value="economico">Econômico</option>
						<option value="intermediario">Intermediário</option>
						<option value="suv">SUV</option>
						<option value="executivo">Executivo</option>
					</select>
				</div>

				<div class="form-group col-md-2 id ="divtarifa" >
					<label for="exampleInputEmail1">Tarifa dia </label> <input
						type="text" class="form-control" id="tarifa" name="tarifa"
						value="${carro.tarifaDia }" readonly />
				</div>


				<div class="col-md-2 col-md-offset-4">
					<label for="">* campos obrigatórios</label>
				</div>

				<input type="hidden" name="logica" value="AlterarCarro" />

				<div class="col-md-12 col-md-offset-4">
					<br> <br>
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="adicionarCarro.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>




		</form>
	</div>






	<script src="js/bootstrap.min.js"></script>
</body>
</html>