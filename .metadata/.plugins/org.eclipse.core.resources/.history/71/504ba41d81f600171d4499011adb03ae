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

import com.adnaloy.librosykekas.basics.interfaces.IndexPageWEBLocal;

/**
 * Servlet implementation class index
 */
@WebServlet(description = "main accessto the website", urlPatterns = { "/index" })
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="IndexPageWEB")
	IndexPageWEBLocal ipw;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
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
		ipw.buscoIndexPageWEB();
		
		request.setAttribute("presentation", ipw.getPresentacion());
		request.setAttribute("comentario_1", ipw.getComentario1());
		request.setAttribute("comentario_2", ipw.getComentario2());
		request.setAttribute("comentario_3", ipw.getComentario3());
		
		request.setAttribute("imagen_1", ipw.getImg1());
		request.setAttribute("imagen_2", ipw.getImg2());
		request.setAttribute("imagen_3", ipw.getImg3());
		request.setAttribute("imagen_4", ipw.getImg4());
		request.setAttribute("imagen_5", ipw.getImg5());
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
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
