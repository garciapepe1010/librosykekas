package com.adnaloy.librosykekas.librosykekasWEB.basic;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adnaloy.librosykekas.basics.interfaces.AcercaDePageWebLocal;

/**
 * Servlet implementation class inside
 */
@WebServlet(description = "inside Make", urlPatterns = { "/inside" })
public class inside extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="AcercaDePageWeb")
	AcercaDePageWebLocal ipw;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inside() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setAttribute("timestamp", new Date());
		ipw.setClave("1");
		ipw.buscoAcercaDePageWEB();
		
		request.setAttribute("acercade", ipw.getAcercade());
		request.setAttribute("aunmas", ipw.getAunmas());
		request.setAttribute("clave", ipw.getClave());
		request.setAttribute("historia", ipw.getHistoria());
		request.setAttribute("inquietudes", ipw.getInquietudes());
		request.setAttribute("kekas", ipw.getKekas());
		request.setAttribute("libros", ipw.getLibros());
		request.setAttribute("viajes", ipw.getViajes());
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/inside.jsp");
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
