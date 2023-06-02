package com.pawel.auctionwebsite.infrastructure.entity;

import com.pawel.auctionwebsite.domain.model.auction.MainCategory;

import javax.persistence.*;
import java.util.List;

public class CategoryDict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MainCategory mainCategory;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoryEntry> entries;
}
