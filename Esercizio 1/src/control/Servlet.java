package control;
import model.Calcolatore;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float h, b;
		h = Float.parseFloat(request.getParameter("altezza"));
		b = Float.parseFloat(request.getParameter("base"));
		
		Calcolatore calc = new Calcolatore();
		float area = calc.calcola(b, h);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("L'area del rettangolo è: " + area);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
