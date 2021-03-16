import controller.CountryHelper;
import model.Country;

/**
 * @author Daniel De Lima - dcdelima
 * CIS 175 - Spring 2021
 * Mar 8, 2021
 */


/**
 * 
 * The purpose of this class is to test persisting to the Cars database table "countries"
 * 
 */
public class CountryTester {

	public static void main(String[] args) {
		CountryHelper ch = new CountryHelper();
		Country country = new Country("Spain");
		ch.save(country);
		
		Country singapore = new Country("Singapore");
		ch.save(singapore);
	}
}