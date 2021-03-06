package com.adnaloy.librosykekas.adminuno;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adnaloy.librosykekas.basics.interfaces.EditorialFabLocal;
import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;

/**
 * Servlet implementation class EdFabWebPage
 */
@WebServlet(description = "Page from Ed Fab", urlPatterns = { "/EdFabWebPage" })
public class EdFabWebPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="EditorialFab")
	EditorialFabLocal ef;
	@EJB(mappedName="Parameters")
	ParametersLocal prm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EdFabWebPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List efs = ef.findAllEditorialFab();
		
		request.setAttribute("ListaEditFab", efs);
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EdFabListWebPage.jsp");
        dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String destino = "/EdFabEditWebPage.jsp";
		
		String accion = request.getParameter("accion");
		String cod = request.getParameter("codigo");
		
		if("E".equals(accion)) {
			
			ef.setCode(cod);
			ef.buscaEditorialFab();
			
			request.setAttribute("EditFab", ef);
			request.setAttribute("EditFabAccion","E");
			
			destino = "/EdFabEditWebPage.jsp";
			
		}else if("A".equals(accion)) {
			
			request.setAttribute("EditFab", ef);
			request.setAttribute("EditFabAccion","A");
			
			destino = "/EdFabEditWebPage.jsp";
			
		}else if("X".equals(accion)) {
			
			ef.setCode(cod);
			ef.buscaEditorialFab();
			
			request.setAttribute("EditFab", ef);
			request.setAttribute("EditFabAccion","X");
			
			destino = "/EdFabEditWebPage.jsp";
			
		}else if("D".equals(accion)) {
			
			ef.setCode(cod);
			ef.buscaEditorialFab();
			
			request.setAttribute("EditFab", ef);
			request.setAttribute("EditFabAccion","D");
			
			destino = "/EdFabEditWebPage.jsp";
			
		}else if("XE".equals(accion)) {
			
			ef.setCode(cod);
			ef.buscaEditorialFab();
			
			ef.setDireccion(request.getParameter("direccion"));
			ef.setEmail(request.getParameter("email"));
			ef.setNombre(request.getParameter("nombre"));
			
			ef.actualizo();
			
			ef.reset();
			
			List efs = ef.findAllEditorialFab();
			
			request.setAttribute("ListaEditFab", efs);
			
			destino = "/EdFabListWebPage.jsp";
			
		}else if("XA".equals(accion)) {
			
			ef.setDireccion(request.getParameter("direccion"));
			ef.setEmail(request.getParameter("email"));
			ef.setNombre(request.getParameter("nombre"));
			
			ef.anado();
			
			ef.reset();
			
			List efs = ef.findAllEditorialFab();
			
			request.setAttribute("ListaEditFab", efs);
			
			destino = "/EdFabListWebPage.jsp";
			
		}else if("XX".equals(accion)) {
			
			ef.setCode(cod);
			ef.buscaEditorialFab();
			ef.elimino();
			
			ef.reset();
			
			List efs = ef.findAllEditorialFab();
			
			request.setAttribute("ListaEditFab", efs);
			
			destino = "/EdFabListWebPage.jsp";
			
		}else if("XD".equals(accion)) {
			
			ef.setDireccion(request.getParameter("direccion"));
			ef.setEmail(request.getParameter("email"));
			ef.setNombre(request.getParameter("nombre"));
			
			ef.actualizo();
			
			List efs = ef.findAllEditorialFab();
			
			request.setAttribute("ListaEditFab", efs);
			
			destino = "/EdFabListWebPage.jsp";
		}
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destino);
        dispatcher.forward(request, response);
		
	}

}
