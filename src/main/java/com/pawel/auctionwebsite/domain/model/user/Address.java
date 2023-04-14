package com.pawel.auctionwebsite.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Address {
    String street;
    String city;
    String voivodeship;
    String postcode;
    String houseNumber;
}
