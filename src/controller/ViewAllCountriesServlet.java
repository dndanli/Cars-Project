/**
 * @author Daniel De Lima - dcdelima
 * CIS 175 - Spring 2021
 * Mar 8, 2021
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllCountriesServlet
 */
@WebServlet("/viewCountries")
public class ViewAllCountriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCountriesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*Creating instance of helper class*/
		CountryHelper dao = new CountryHelper();
		
		/*The JSP that displays the countries*/
		String path = "/countries-list.jsp";
		
		/*Saving object in session*/
		request.setAttribute("allCountries", dao.findAll());
		
		/* Redirects the user to the main page in case
		 * there are no countries in the database.
		 */
		if(dao.findAll().isEmpty()) {
			path = "/index.html";
		}
		
		/*Sending the request to the JSP path*/
		getServletContext().getRequestDispatcher(path).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
