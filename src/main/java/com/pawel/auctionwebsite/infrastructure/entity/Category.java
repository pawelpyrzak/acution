package com.pawel.auctionwebsite.infrastructure.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private MainCategoryDict mainCategoryDict;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubCategoryDict> subCategoryDicts;
}
