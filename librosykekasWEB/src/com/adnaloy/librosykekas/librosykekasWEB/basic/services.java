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

import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;

/**
 * Servlet implementation class services
 */
@WebServlet("/services")
public class services extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="Parameters")
	ParametersLocal prm;
       
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
		
		request.setAttribute("timestamp", new Date());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/services.jsp");
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
