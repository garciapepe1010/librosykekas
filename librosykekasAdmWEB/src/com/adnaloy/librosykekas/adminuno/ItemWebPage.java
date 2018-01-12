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
import com.adnaloy.librosykekas.basics.interfaces.EditorialFabLocal;
import com.adnaloy.librosykekas.basics.interfaces.ItemLocal;
import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;

/**
 * Servlet implementation class ItemWebPage
 */
@WebServlet(description = "Mant. Items", urlPatterns = { "/ItemWebPage" })
public class ItemWebPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="Item")
	ItemLocal itm;
	@EJB(mappedName="Categoria")
	CategoriaLocal cat;
	@EJB(mappedName="EditorialFab")
	EditorialFabLocal ef;
	@EJB(mappedName="Parameters")
	ParametersLocal prm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemWebPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List efs = itm.findAllItems();
		
		request.setAttribute("ListaItem", efs);
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ItemListWebPage.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
String destino = "/ItemEditWebPage.jsp";
		
		String accion = request.getParameter("accion");
		String cod = request.getParameter("codigo");
		
		String titulo = request.getParameter("titulo");
		String resena = request.getParameter("resena");
		String comentario = request.getParameter("comentario");
		String categoria = request.getParameter("categoria");
		String editorialFab = request.getParameter("editorialFab");
		
		if("E".equals(accion)) {
			
			itm.setCode(cod);
			itm.buscaItem();
			List cats = cat.findAllCategorias();
			List efs= ef.findAllEditorialFab();
			
			request.setAttribute("Item", itm);
			request.setAttribute("Cats", cats);
			request.setAttribute("Efs", efs);
			request.setAttribute("ItemAccion","E");
			
			destino = "/ItemEditWebPage.jsp";
			
		}else if("A".equals(accion)) {
			
			request.setAttribute("Item", itm);
			request.setAttribute("ItemAccion","A");
			
			
			List cats = cat.findAllCategorias();
			List efs= ef.findAllEditorialFab();
			
			request.setAttribute("Cats", cats);
			request.setAttribute("Efs", efs);
			
			destino = "/ItemEditWebPage.jsp";
			
		}else if("X".equals(accion)) {
			
			itm.setCode(cod);
			itm.buscaItem();
			
			request.setAttribute("Item", itm);
			request.setAttribute("ItemAccion","X");
			
			List cats = cat.findAllCategorias();
			List efs= ef.findAllEditorialFab();
			request.setAttribute("Cats", cats);
			request.setAttribute("Efs", efs);
			
			destino = "/ItemEditWebPage.jsp";
			
		}else if("D".equals(accion)) {
			
			itm.setCode(cod);
			itm.buscaItem();
			
			request.setAttribute("Item", itm);
			request.setAttribute("ItemAccion","D");
			
			List cats = cat.findAllCategorias();
			List efs= ef.findAllEditorialFab();
			request.setAttribute("Cats", cats);
			request.setAttribute("Efs", efs);
			
			destino = "/ItemEditWebPage.jsp";
			
		}else if("XE".equals(accion)) {
			
			itm.setCode(cod);
			itm.buscaItem();
			
			cat.setClave(categoria);
			cat = cat.buscaCategoria();
			
			ef.setCode(editorialFab);
			ef = ef.buscaEditorialFab();
			
			itm.setCategoria(cat);
			itm.setComentario(comentario);
			itm.setEditorial(ef);
			itm.setResena(resena);
			itm.setTitulo(titulo);
			
			itm.actualizo();
			
			itm.reset();
			
			List efs = itm.findAllItems();
			
			request.setAttribute("ListaItem", efs);
			
			destino = "/ItemListWebPage.jsp";
			
		}else if("XA".equals(accion)) {
			
			cat.setClave(categoria);
			cat = cat.buscaCategoria();
			
			ef.setCode(editorialFab);
			ef = ef.buscaEditorialFab();
			
			itm.setCategoria(cat);
			itm.setComentario(comentario);
			itm.setEditorial(ef);
			itm.setResena(resena);
			itm.setTitulo(titulo);
			
			itm.anado();
			
			itm.reset();
			
			List efs = itm.findAllItems();
			
			request.setAttribute("ListaItem", efs);
			
			destino = "/ItemListWebPage.jsp";
			
		}else if("XX".equals(accion)) {
			
			itm.setCode(cod);
			itm.buscaItem();
			itm.elimino();
			
			itm.reset();
			
			List efs = itm.findAllItems();
			
			request.setAttribute("ListaItem", efs);
			
			destino = "/ItemListWebPage.jsp";
			
		}else if("XD".equals(accion)) {
			
			itm.reset();
			
			cat.setClave(categoria);
			cat = cat.buscaCategoria();
			
			ef.setCode(editorialFab);
			ef = ef.buscaEditorialFab();
			
			itm.setCategoria(cat);
			itm.setComentario(comentario);
			itm.setEditorial(ef);
			itm.setResena(resena);
			itm.setTitulo(titulo);
			
			itm.anado();
			
			itm.reset();
			
			List efs = itm.findAllItems();
			
			request.setAttribute("ListaItem", efs);
			
			destino = "/ItemListWebPage.jsp";
		}
		
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destino);
        dispatcher.forward(request, response);
	}

}
