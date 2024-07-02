package com.yaminibalaji.HotelBooking.Controller;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Registration.Signing;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaminibalaji.HotelBooking.Model.Hotel;
import com.yaminibalaji.HotelBooking.Service.HotelServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelServiceImp hotelServiceImp;
	
	@PostMapping("/create")
	public void createHotel(@Valid @RequestBody Hotel hotel, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new RuntimeException("Request not valid");
		}
		hotelServiceImp.createHotel(hotel);
		
	}
	
	@GetMapping("/id/{hotelId}")
	public Hotel getHotelById(@PathVariable String hotelId) {
		return hotelServiceImp.getHotelById(hotelId);
		
	}
	
	@GetMapping("/all")
	public List<Hotel> getAllHotels() {
		return hotelServiceImp.getAllHotels();
		
	}
	
	@DeleteMapping("/remove/id/{id}")
	public void deleteHotelById(@PathVariable String id) {
		hotelServiceImp.deleteHotelById(id);
		
	}
	
	@PutMapping("/update")
	public void updatehotel(@RequestBody Hotel hotel) {
		hotelServiceImp.updateHotel(hotel);
	}
	

}
