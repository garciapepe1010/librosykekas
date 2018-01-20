package com.adnaloy.librosykekas.librosykekasWEB.basic;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adnaloy.librosykekas.basics.interfaces.CategoriaLocal;
import com.adnaloy.librosykekas.basics.interfaces.EditorialFabLocal;
import com.adnaloy.librosykekas.basics.interfaces.ItemLocal;
import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;

/**
 * Servlet implementation class services
 */
@WebServlet("/services")
public class services extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="Parameters")
	ParametersLocal prm;
	@EJB(mappedName="Categoria")
	CategoriaLocal cat;
	@EJB(mappedName="EditorialFab")
	EditorialFabLocal ef;
	@EJB(mappedName="Item")
	ItemLocal itm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public services() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		List cats = cat.findAllCategorias();
		List efs= ef.findAllEditorialFab();
		

		request.setAttribute("Cats", cats);
		request.setAttribute("Efs", efs);
		
		List threeItems = itm.findThreeItems();
		request.setAttribute("ThreeItems", threeItems);
		
		request.setAttribute("timestamp", new Date());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/services.jsp");
        dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String categoria = request.getParameter("categoria");
		String editorialFab = request.getParameter("editorialFab");
		String titulo = request.getParameter("titulo");
		String resena = request.getParameter("resena");
		
		itm.setFiltroCategoria(categoria);
		itm.setFiltroEditorial(editorialFab);
		itm.setFiltroResena(resena);
		itm.setFiltroTitulo(titulo);
		
		List threeItems = itm.findItems();
		request.setAttribute("ThreeItems", threeItems);
		
		
		List cats = cat.findAllCategorias();
		List efs= ef.findAllEditorialFab();
		

		request.setAttribute("Cats", cats);
		request.setAttribute("Efs", efs);
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/services.jsp");
        dispatcher.forward(request, response); 
		
	}

}
