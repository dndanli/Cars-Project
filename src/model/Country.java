package model;

import javax.persistence.*;

/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Mar 7, 2021
 */
@Entity
@Table(name="countries")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COUNTRY_ID")
	private int countryId;
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	public Country() {
		super();
	}

	public Country(String countryId) {
		super();
		this.countryName = countryId;
	}

	public int getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + "]";
	}
	
	
}
