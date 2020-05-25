package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Mueble;
import model.JugadorModel;
import model.MuebleModel;

/**
 * Servlet implementation class MuebleControlador
 */
@WebServlet("/insertaMueble")
public class MuebleControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1 Recibe los parámetros
			//Son los nombres de las caja de textos en el JSP
			String precio = request.getParameter("precio");
			String stock = request.getParameter("stock");
		
			//2 Se crea el objeto Alumno
			Mueble obj = new Mueble();
			obj.setPrecio(Integer.parseInt(precio));
			obj.setStock(Integer.parseInt(stock));
			
			
		MuebleModel m = new MuebleModel();
			int s = m.insertaMueble(obj);
			if (s>0)
				request.getSession().setAttribute("MENSAJE", "registro exitoso");
			else
				request.getSession().setAttribute("MENSAJE", "registro erróneo");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("MENSAJE", "registro erróneo");
		} finally {
			response.sendRedirect("registraJugador.jsp");
		}
	}
	}

