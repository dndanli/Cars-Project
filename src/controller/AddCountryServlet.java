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

import model.Country;

/**
 * Servlet implementation class AddCountriesServlet
 * This servlet is used to add the countries to the database.
 */
@WebServlet("/addCountryServlet")
public class AddCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCountryServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*Creating instance of helper method*/
		CountryHelper dao = new CountryHelper();
		
		/*Getting value of request and assigning to a variable*/
		String countryName = request.getParameter("countryName");
		
		/*Creating instance of model class with the request*/
		Country country = new Country(countryName);
		
		//Persisting the country object
		dao.save(country);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}
}
