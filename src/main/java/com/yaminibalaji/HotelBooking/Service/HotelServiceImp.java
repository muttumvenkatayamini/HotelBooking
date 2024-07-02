package com.yaminibalaji.HotelBooking.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.yaminibalaji.HotelBooking.Exception.HotelNotFoundException;
import com.yaminibalaji.HotelBooking.Model.Hotel;

@Service
public class HotelServiceImp {
	List<Hotel> hotelList = new ArrayList<>();

	Map<String, Hotel> hotelMap = new HashMap<>();

	public void createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		hotelList.add(hotel);
		hotelMap.put(hotel.getId(), hotel);

	}

	public Hotel getHotelById(String hotelId) {
		if (ObjectUtils.isEmpty(hotelMap.get(hotelId))) {
			throw new HotelNotFoundException("hotel not found for id : " + hotelId);
		}

		return hotelMap.get(hotelId);

	}

	public List<Hotel> getAllHotels() {

		return hotelList;
	}

	public void deleteHotelById(String id) {
		// TODO Auto-generated method stub
		Hotel hotel = getHotelById(id);
		hotelList.remove(hotel);
		hotelMap.remove(id);
	}

	public void updateHotel(Hotel hotel) {
		// get the previous or existing data of the hotel
		Hotel existingHotel = getHotelById(hotel.getId());
		// remove old data
		hotelList.remove(existingHotel);
		// add the updated data to list
		hotelList.add(hotel);
		// update the previous data with new data & update the map
		hotelMap.put(hotel.getId(), hotel);

	}

}
