<%@page import="ppi.agenda.DAO.ContatoDAO"%>
<%@page import="ppi.agenda.model.Contato"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>CRUD com Bootstrap 3</title>
 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>


<link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">




</head>
<body>


<%@include file="cabecalho.jsp" %>

 
 
 <div id="main" class="container-fluid">
  
  <h3 class="page-header text-center"> Reservas </h3>
  
 
 <div class="col-sm-4 col-sm-offset-4">
    <div class="input-group">
      <input type="text" class="form-control" placeholder="Pesquisar por código de reserva">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Go!</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
 

	<br>
	<h3 class="page-header text-center">Quantidade de carros armazenados
	</h3>
	<br>

	<div class="container">

		<div class="table-responsive">
			<table class="table">
				<thead class="thead-inverse">
					<tr>
						<th>Quantidade</th>
						<th>Modelo</th>
						<th>Categoria</th>
						
					</tr>

				</thead>

				<tbody>


					<jsp:useBean id="dao" class="ppi.agenda.dao.CarrosDao" />

					<c:forEach var="carro" items="${dao.consultarQuantidade}">
						<tr>
							<td>${carro[0]}</td>
							<td>${carro[1]}</td>
							<td>${carro[2]}</td>
							
							<td>
							
						
						</tr>
					</c:forEach>







				</tbody>
			</table>
		</div>
	</div>



 <script src="js/bootstrap.min.js"></script>
</body>
</html>