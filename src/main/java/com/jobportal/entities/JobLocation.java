package com.jobportal.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "job_location")
public class JobLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	private String city;
	private String country;
	private String state;

	public JobLocation(Integer id, String city, String country, String state) {
		this.Id = id;
		this.city = city;
		this.country = country;
		this.state = state;
	}

	public JobLocation() {

	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "JobLocation{" +
				"id=" + Id +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", state='" + state + '\'' +
				'}';
	}
}
