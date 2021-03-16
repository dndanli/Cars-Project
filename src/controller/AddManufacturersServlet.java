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
import model.Manufacturer;

/**
 * Servlet implementation class AddManufacturers
 * This servlet is used to add the manufacturers to the database
 * It needs the name of a manufacturer and the country where it's from.
 */
@WebServlet("/addManufacturersServlet")
public class AddManufacturersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddManufacturersServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		/*Creating instance of helper methods*/
		ManufacturerHelper dao = new ManufacturerHelper();
		CountryHelper ch = new CountryHelper();
		
		/*Defining column components and saving to session*/
		String manufacturerName = request.getParameter("manufacturerName");
		String countryName = request.getParameter("country");
		
		Country country = ch.findCountry(countryName);
		
		/*Creating new instance of model class with saved requests*/
		Manufacturer manufacturer = new Manufacturer(country, manufacturerName);
		
		// persisting manufacturer to database
		dao.save(manufacturer);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
