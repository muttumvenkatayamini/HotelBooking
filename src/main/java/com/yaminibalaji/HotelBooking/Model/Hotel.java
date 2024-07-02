package com.yaminibalaji.HotelBooking.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Hotel {

	private String id;

	@Size(min = 3)
	private String name;
	@Min(value = 1)
	@Max(value = 10)
	private Long rating;

	private String city;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(String id, String name, Long rating, String city) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", rating=" + rating + ", city=" + city + "]";
	}

}
