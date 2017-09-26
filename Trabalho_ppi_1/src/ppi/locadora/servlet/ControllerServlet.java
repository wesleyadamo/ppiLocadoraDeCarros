package ppi.locadora.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ppi.locadora.logica.Logica;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			
			String parametro = request.getParameter("logica");
			
			String nomeDaClasse = "ppi.locadora.logica." + parametro;
			
			try {
				Class classe = Class.forName(nomeDaClasse);
				Logica logica = (Logica) classe.newInstance();
				String pagina = logica.executa(request, response);
				request.getRequestDispatcher(pagina).forward(request, response);
				} catch (Exception e) {
				throw new ServletException(
				"A lógica de negócios causou uma exceção", e);
				}
			

			
			/*

			CarrosDao ca = new CarrosDao();

			if(tipo.equalsIgnoreCase("1")) {
				String m = request.getParameter("modelo");
				String c = request.getParameter("options");
				String r = request.getParameter("renavan");
				String a = request.getParameter("ano");
				String t = request.getParameter("tarifa");
				
				
				
				ca.adicionaCarro(m, c, r, a, Float.valueOf(t), 0, 0);
			}
			
			else if(tipo.equals("2")) {
				String id = request.getParameter("id");
				ca.removerCarro(Integer.parseInt(id));

			} else {
				
				String m = request.getParameter("carro");
				System.out.println(m);
			}

			
			
			response.sendRedirect("listagemcarros.jsp");		

			//request.setAttribute("contatoBusca",contatos); */
			
		}
		
	}
	
