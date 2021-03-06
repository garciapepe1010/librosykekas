package com.adnaloy.librosykekas.adminuno;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adnaloy.librosykekas.basics.interfaces.ParametersLocal;

/**
 * Servlet implementation class LogOut
 */
@WebServlet(description = "Log out", urlPatterns = { "/LogOut" })
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB(mappedName="Parameters")
	ParametersLocal prm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession sess = request.getSession(false);
		if (sess != null)
		      sess.invalidate();

		   request.logout();
		   
		   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/logout.jsp");
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
