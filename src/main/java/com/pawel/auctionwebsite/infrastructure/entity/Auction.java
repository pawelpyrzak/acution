package com.pawel.auctionwebsite.infrastructure.entity;

import com.pawel.auctionwebsite.infrastructure.HighestOffer;
import com.pawel.auctionwebsite.infrastructure.model.Promo;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    String uuid;
    String title;
    String description;
    @OneToOne
    Category category;
    BigDecimal instantPurchasePrice;
    boolean instantPurchase;
    BigDecimal minAmount;
    @Enumerated(EnumType.STRING)
    Promo promo;
    String location;
    LocalDateTime dateOfIssue;
    LocalDateTime endDate;
    int numberOfVisits;
    @Embedded
    HighestOffer highestOffer;
    boolean visible;
}
