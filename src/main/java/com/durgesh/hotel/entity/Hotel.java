package com.durgesh.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    private String address;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private String phone;

    @Column(unique = true, nullable = false)
    private String email;

    private HotelStatus hotelStatus;

    @CreationTimestamp
    private ZonedDateTime createTs;

    @UpdateTimestamp
    private ZonedDateTime updateTs;
}