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

/**
 * Servlet implementation class CategoriaWebPage
 */
@WebServlet(description = "Mant Categorias", urlPatterns = { "/CategoriaWebPage" })
public class CategoriaWebPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="Categoria")
	CategoriaLocal ef;
       
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
		
		request.setAttribute("ListaEditFab", efs);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EdFabListWebPage.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
