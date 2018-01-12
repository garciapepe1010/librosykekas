package com.adnaloy.librosykekas.adminuno;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adnaloy.librosykekas.basics.interfaces.usuarioLocal;


/**
 * Servlet implementation class index
 */
@WebServlet(description = "controller for librosykekas administration app", urlPatterns = { "/" })
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "librosykekasadmin"
                }),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {
                        "librosykekasadmin"
                })
        })
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="usuario")
	usuarioLocal usr;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		request.setAttribute("timestamp", new Date());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index");
        dispatcher.forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response); 
		
		
	}

}
