<%@page import="ppi.agenda.DAO.ContatoDAO"%>
<%@page import="ppi.agenda.model.Contato"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bulma.css">
    
    <title>Agenda PPI</title>


</head>
<body>

<%@include file="header.jsp"%>
	
	<!-- Hero footer: will stick at the bottom -->
	<div class="hero-foot">
	    <nav class="tabs is-boxed is-fullwidth">
	      <div class="container">
	      
	      
	        <ul>
	          <li><a href="index.jsp">Principal</a></li>
	          <li><a href="adicionar.jsp">Adicionar</a></li>
	          <li class="is-active"><a>Agenda</a></li>
	        </ul>
	        
	        
	      </div>
	    </nav>
	 </div>
</section>



<!-- CAMPO DE BUSCA -->
<form action="buscaServlet" method="post">
	<div class="columns is-mobile">
	  <div class="column is-offset-8">
			<div class="field has-addons">
			  <div class="control">
			    <input class="input" type="text" placeholder="Nome" name="nomeBusca">
			  </div>
			  <div class="control">
			    <button class="button is-info">Procurar</button>
			  </div>
			  <div class="control">
  				<a class="button is-warning" href="agenda.jsp">Voltar</a>
  			  </div>
			</div>
		</div>
	</div>
</form>





<table class="table is-striped is-fullwidth">

	<!--  CABEÇALHO DA TABELA -->
  <thead>
    <tr>
      <th>ID</th>
      <th>nome</th>
      <th>Email</th>
      <th>Endereço</th>
      <th>Nascimento</th>
      <th>Telefone</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  
 
  <tbody>
  	
  	<%
			
			List<Contato> contatos = (ArrayList<Contato>) request.getAttribute("contatoBusca");

  			if(contatos != null && contatos.size() > 0){
				for (Contato contato : contatos ) {
				
	%>
	
	 <tr>
	 		<%
				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
			%>
	 		
	 		<% long id = contato.getId(); %>
	 		<% String nome = contato.getNome(); %>
	 		<% String email = contato.getEmail(); %>
	 		<% String endereco = contato.getEndereco(); %>
	 		<% String dataAniversario = data.format(contato.getDataNascimento().getTime()); %>
	 		<% String telefone = contato.getTelefone(); %>
	 		
	 		<!-- ELEMENTOS DA TABELA -->
	 		
  			<td><%=id%></td>
			<td><%=nome%></td>
			<td><%=email %></td>
			<td><%=endereco %></td>
			<td><%=dataAniversario %></td>
			<td><%=telefone %></td>
			
		
		
				<!-- BOTOES -->
			<td>
			<a class="button is-info is-hovered" href="editar.jsp?id=<%=id%>">Editar</a>
			</td>
			
			
			<td>
			<form action="deleteServlet" method="post">
			<input type="hidden" name="id" value="<%=id%>">
			<input type="hidden" name="nome" value="<%=nome%>">
			<input type="hidden" name="email" value="<%=email%>">
			<input type="hidden" name="endereco" value="<%=endereco%>">
			<input type="hidden" name="data" value="<%=dataAniversario%>">
			<input type="hidden" name="telefone" value="<%=telefone%>">
			
			<button class="button is-danger is-hovered" name="button" value="excluir">Excluir</button>
			</form>
			</td>
			
			
		</tr>
		
	<%
				}
  		} else {
	%>
		
  		
  	
  </tbody>
</table>
		
		<!-- TEXTO EM CASO DE RETORNAR NENHUM RESULTADO -->
		<h3 class="title has-text-centered">Nenhum Contato Encontrado</h3>
  		
  			
  	<%		
  		}
	%> 
	




</body>
</html>