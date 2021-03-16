import java.util.List;

import controller.CountryHelper;
import controller.ManufacturerHelper;
import controller.VehicleHelper;
import model.Country;
import model.Manufacturer;
import model.Vehicle;

/**
 * @author Daniel - dcdelima
 * CIS 175 - Spring 2021
 * Mar 10, 2021
 */

/**
 * The purpose of this class is to test persisting to the Cars database table "manufacturers" 
 * Each manufacturer needs a name and the country where its from.
 */
public class ManufacturerTester {

	public static void main(String[] args) {
		ManufacturerHelper manHelper = new ManufacturerHelper();
		CountryHelper countryHelper = new CountryHelper();
		VehicleHelper vehicleHelper = new VehicleHelper();
		
//		Country country = new Country("Philippines");
//		countryHelper.save(country);
//		List<Country> countries = countryHelper.findAll();
//		int i;
//		for (i = 0; i < countries.size(); i++) {
//			if (countries.get(i).getCountryName().equals("Philippines")) break;
//		}
//		Country country = countries.get(i);
//		
//		
//		Manufacturer manufacturer = new Manufacturer(country, "Motorworks Philippines");
//		manHelper.save(manufacturer);
		
		List<Manufacturer> ml = manHelper.findAll();
		ml.forEach(System.out::println);
		List<Country> cl = countryHelper.findAll();
		cl.forEach(System.out::println);
		List<Vehicle> vl = vehicleHelper.findAll();
		vl.forEach(System.out::println);
	}
}
