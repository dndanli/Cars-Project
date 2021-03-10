package model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Mar 7, 2021
 */
@Entity
@Table(name="vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VIN_ID")	
	private int vinId;
	@Column(name="MODEL")
	private String model;
	@Column(name="MAN_DATE")
	private LocalDate manDate;
	@Column(name="COLOR")
	private String color;
	@Column(name="TRANS")
	private String trans;
	@Column(name="SEATS")
	private int seats;
	@Column(name="MPG")
	private BigDecimal mpg;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name="MAN_ID")
	private Manufacturer manufacturer;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String model, LocalDate manDate, String color, String trans, int seats, 
			BigDecimal mpg, Manufacturer manufacturer) {
		super();
		this.model = model;
		this.manDate = manDate;
		this.color = color;
		this.trans = trans;
		this.seats = seats;
		this.mpg = mpg;
		this.manufacturer = manufacturer;
	}

	public int getVinId() {
		return vinId;
	}

	public String getModel() {
		return model;
	}

	public LocalDate getManDate() {
		return manDate;
	}

	public String getColor() {
		return color;
	}

	public String getTrans() {
		return trans;
	}

	public int getSeats() {
		return seats;
	}

	public BigDecimal getMpg() {
		return mpg;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	
	@Override
	public String toString() {
		return "Vehicle [vinId=" + vinId + ", model=" + model + ", manDate=" + manDate + 
				", color=" + color + ", trans=" + trans + ", seats=" + seats + 
				", mpg=" + mpg + ", manufacturer=" + manufacturer.getManufacturerName() + "]";
	}

}