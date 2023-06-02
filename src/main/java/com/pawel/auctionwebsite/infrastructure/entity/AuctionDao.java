package com.pawel.auctionwebsite.infrastructure.entity;

import com.pawel.auctionwebsite.domain.model.auction.Category;
import com.pawel.auctionwebsite.domain.model.user.Promo;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuctionDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    String uuid;
    String title;
    String description;
    @OneToMany
    CategoryDict categoryDict;
    BigDecimal buyNow;
    BigDecimal minAmount;
    @Enumerated(EnumType.STRING)
    Promo promo;
    String location;
    LocalDateTime dateOfIssue;
    LocalDateTime endDate;
    int numberOfVisits;
}
