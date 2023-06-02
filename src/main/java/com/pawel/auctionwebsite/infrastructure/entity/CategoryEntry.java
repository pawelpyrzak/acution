package com.pawel.auctionwebsite.infrastructure.entity;


import com.pawel.auctionwebsite.domain.model.auction.SubCategory;

import javax.persistence.*;

@Entity
    public class CategoryEntry {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated(EnumType.STRING)
        private SubCategory subCategory;
}
