package com.pawel.auctionwebsite.domain.model.auction;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@Setter
public class Auction {
    String uuid;
    String title;
    String description;
    Category category;
    BigDecimal buyNow;
    BigDecimal minAmount;
    Enum promo;
    String location;
    LocalDateTime dateOfIssue;
    LocalDateTime endDate;
    int numberOfVisits;
}
