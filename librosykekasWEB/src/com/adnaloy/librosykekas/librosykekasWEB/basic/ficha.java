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
import com.adnaloy.librosykekas.basics.interfaces.SliderLocal;

/**
 * Servlet implementation class ficha
 */
@WebServlet(description = "Ficha del item", urlPatterns = { "/ficha" })
public class ficha extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="Parameters")
	ParametersLocal prm;
	@EJB(mappedName="Item")
	ItemLocal itm;
	@EJB(mappedName="Slider")
	SliderLocal sldr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ficha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		prm.cargodatos();
		request.setAttribute("prm", prm);
		
		String code = request.getParameter("code");
		
		itm.setCode(code);
		itm.buscaItem();
		
		
		request.setAttribute("titulo", itm.getTitulo());
		request.setAttribute("resena", itm.getResena());
		request.setAttribute("editorial", itm.getEditorial().getNombre());
		request.setAttribute("comentario", itm.getComentario());
		
		request.setAttribute("timestamp", new Date());
		
		List sldrs = sldr.findAllSliders();
		request.setAttribute("sldrs", sldrs);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ficha.jsp");
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
