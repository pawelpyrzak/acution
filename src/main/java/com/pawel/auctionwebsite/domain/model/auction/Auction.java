package com.pawel.auctionwebsite.domain.model.auction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Auction {
    String title;
    String description;
    String category;
    BigDecimal buyNow;
    BigDecimal minAmount;
    Enum promo;
    String location;
    LocalDateTime dateOfIssue;
    LocalDateTime endDate;
    int numberOfVisits;
}
