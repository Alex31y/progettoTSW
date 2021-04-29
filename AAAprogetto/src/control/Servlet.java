package control;
import model.*;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Database db = new Database();
		ArticoloBean elemento;
		RequestDispatcher view;
		Carrello cart = (Carrello) session.getAttribute("carrello");
		if(cart == null)
			cart = new Carrello();
		
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
		
			
			if(paramName.contains("aquista")) {
				elemento = db.getArticolo(Integer.parseInt(paramName.substring(7)));
				cart.addArticolo(elemento);
				session.setAttribute("carrello", cart);
				
				view = request.getRequestDispatcher("carrello.jsp");
				view.forward(request, response);
			}
			else if(paramName.contains("rimuovi")){
				elemento = db.getArticolo(Integer.parseInt(paramName.substring(7)));
				cart.removeArticolo(elemento);
				session.setAttribute("carrello", cart);
				
				view = request.getRequestDispatcher("carrello.jsp");
				view.forward(request, response);
			}
			else if(paramName.contains("dettagli")) {
				session.setAttribute("idElem", Integer.parseInt(paramName.substring(8)));
				view = request.getRequestDispatcher("dettagli.jsp");
				view.forward(request, response);
			}
			else if(paramName.contains("change")) {
				cart.setPezziArticolo(Integer.parseInt(paramName.substring(6)), Integer.parseInt(request.getParameter("val" + paramName.substring(6))));
				
				view = request.getRequestDispatcher("carrello.jsp");
				view.forward(request, response);
			}
			else {
				switch(paramName) {
				case "paga":
					session.removeAttribute("carrello");
					response.sendRedirect("articoli.jsp");
					break;
					
				default:
					System.out.println(paramName);
					break;
				}
			}
		}
	}

}
