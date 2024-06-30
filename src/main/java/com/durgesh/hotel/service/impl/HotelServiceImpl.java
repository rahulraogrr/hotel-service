package com.durgesh.hotel.service.impl;

import com.durgesh.hotel.entity.Hotel;
import com.durgesh.hotel.exception.ResourceNotFoundException;
import com.durgesh.hotel.repository.HotelRepository;
import com.durgesh.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        Hotel hotelToUpdate = getHotelById(String.valueOf(hotel.getId()));
        hotelToUpdate.setName(hotel.getName());
        hotelToUpdate.setPostcode(hotel.getPostcode());
        hotelToUpdate.setAddress(hotel.getAddress());
        hotelToUpdate.setCity(hotel.getCity());
        hotelToUpdate.setCountry(hotel.getCountry());
        hotelToUpdate.setPhone(hotel.getPhone());
        hotelToUpdate.setEmail(hotel.getEmail());
        hotelToUpdate.setHotelStatus(hotel.getHotelStatus());
        return hotelRepository.save(hotelToUpdate);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(UUID.fromString(id))
                .orElseThrow(()-> new ResourceNotFoundException("Hotel with id " + id + " not found"));
    }

    @Override
    public void deleteHotel(String id) {
        hotelRepository.delete(getHotelById(id));
    }
}
