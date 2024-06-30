package com.durgesh.hotel.controller;

import com.durgesh.hotel.entity.Hotel;
import com.durgesh.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.ok(hotelService.createHotel(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> findAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findHotelById(@PathVariable String id) {
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotelById(@PathVariable String id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok("Hotel deleted successfully");
    }

    @PutMapping
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.updateHotel(hotel));
    }

}
