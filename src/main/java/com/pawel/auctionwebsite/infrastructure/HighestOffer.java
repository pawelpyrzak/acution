package com.pawel.auctionwebsite.infrastructure;

import com.pawel.auctionwebsite.infrastructure.entity.AppUser;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HighestOffer {
    AppUser auctionMember;
    BigDecimal amount;
}
