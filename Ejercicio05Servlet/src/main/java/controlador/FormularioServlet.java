package controlador;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entidad.Usuario;
import model.negocio.GestorUsuario;

/**
 * Servlet implementation class FormularioServlet
 */
@WebServlet("/FormularioServlet")
public class FormularioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6210941983530454476L;
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String nombre= request.getParameter("nombre");
        String password= request.getParameter("password");
             
        GestorUsuario gu = new GestorUsuario();
        Usuario user = new Usuario(nombre, password);
        
        int resultado = gu.validarUsuario(user);
        
        if(resultado == 0) {
        	RequestDispatcher rd = request.getRequestDispatcher("bienvenido.jsp");
    		request.setAttribute("nombre", nombre);
    		rd.forward(request, response);
        }
        else {
        	RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        	if(resultado == 1)
        		request.setAttribute("mensaje", "El usuario no existe");
        	else
        		request.setAttribute("mensaje", " Contraseña incorrecta");
        	rd.forward(request, response);
        }
	}

}
