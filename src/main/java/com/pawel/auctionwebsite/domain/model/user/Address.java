package com.pawel.auctionwebsite.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    String street;
    String city;
    String voivodeship;
    String postcode;
    String houseNumber;
}
