package com.durgesh.hotel.service;

import com.durgesh.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelById(String id);
    void deleteHotel(String id);
}