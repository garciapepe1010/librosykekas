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

import com.adnaloy.librosykekas.basics.interfaces.CategoriaLocal;
import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;

/**
 * Servlet implementation class CategoriaWebPage
 */
@WebServlet(description = "Mant Categorias", urlPatterns = { "/CategoriaWebPage" })
public class CategoriaWebPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="Categoria")
	CategoriaLocal ef;
	@EJB(mappedName="Parameters")
	ParametersLocal prm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaWebPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List efs = ef.findAllCategorias();
		
		request.setAttribute("ListaCategoria", efs);
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CategoriaListWebPage.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String destino = "/CategoriaEditWebPage.jsp";
		
		String accion = request.getParameter("accion");
		String cod = request.getParameter("clave");
		
		if("E".equals(accion)) {
			
			ef.setClave(cod);
			ef.buscaCategoria();
			
			request.setAttribute("Categoria", ef);
			request.setAttribute("CategoriaAccion","E");
			
			destino = "/CategoriaEditWebPage.jsp";
			
		}else if("A".equals(accion)) {
			
			request.setAttribute("Categoria", ef);
			request.setAttribute("CategoriaAccion","A");
			
			destino = "/CategoriaEditWebPage.jsp";
			
		}else if("X".equals(accion)) {
			
			ef.setClave(cod);
			ef.buscaCategoria();
			
			request.setAttribute("Categoria", ef);
			request.setAttribute("CategoriaAccion","X");
			
			destino = "/CategoriaEditWebPage.jsp";
			
		}else if("D".equals(accion)) {
			
			ef.setClave(cod);
			ef.buscaCategoria();
			
			request.setAttribute("Categoria", ef);
			request.setAttribute("CategoriaAccion","D");
			
			destino = "/CategoriaEditWebPage.jsp";
			
		}else if("XE".equals(accion)) {
			
			ef.setClave(cod);
			ef.buscaCategoria();
			
			ef.setNombre(request.getParameter("nombre"));
			
			ef.actualizo();
			
			ef.reset();
			
			List efs = ef.findAllCategorias();
			
			request.setAttribute("ListaCategoria", efs);
			
			destino = "/CategoriaListWebPage.jsp";
			
		}else if("XA".equals(accion)) {
			
			ef.setNombre(request.getParameter("nombre"));
			
			ef.anado();
			
			ef.reset();
			
			List efs = ef.findAllCategorias();
			
			request.setAttribute("ListaCategoria", efs);
			
			destino = "/CategoriaListWebPage.jsp";
			
		}else if("XX".equals(accion)) {
			
			ef.setClave(cod);
			ef.buscaCategoria();
			ef.elimino();
			
			ef.reset();
			
			List efs = ef.findAllCategorias();
			
			request.setAttribute("ListaCategoria", efs);
			
			destino = "/CategoriaListWebPage.jsp";
			
		}else if("XD".equals(accion)) {
			
			ef.setNombre(request.getParameter("nombre"));
			
			ef.actualizo();
			
			List efs = ef.findAllCategorias();
			
			request.setAttribute("ListaCategoria", efs);
			
			destino = "/CategoriaListWebPage.jsp";
		}
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destino);
        dispatcher.forward(request, response);
	}

}
