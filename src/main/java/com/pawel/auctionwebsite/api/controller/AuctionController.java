package com.pawel.auctionwebsite.api.controller;

import com.pawel.auctionwebsite.infrastructure.HighestOffer;
import com.pawel.auctionwebsite.infrastructure.model.Promo;
import com.pawel.auctionwebsite.domain.service.AuctionService;
import com.pawel.auctionwebsite.infrastructure.entity.Auction;
import com.pawel.auctionwebsite.infrastructure.entity.Category;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/auction")
public class AuctionController {
    AuctionService auctionService;

    @PostMapping
    public ResponseEntity<Auction> createAuction(String title, String description, Category category,
         BigDecimal instantPurchasePrice, boolean instantPurchase, BigDecimal minAmount, Promo promo, String location){
        return ResponseEntity.ok( auctionService.createAuction(title, description, category, instantPurchasePrice, instantPurchase, minAmount,
                promo, location));

    }

    @PostMapping
    public ResponseEntity<List<Auction>> tenLatestAuctions(){
        return ResponseEntity.ok(auctionService.tenLatestAuctions());
    }
    @PostMapping
    public ResponseEntity<List<Auction>> tenEndingAuctions(){
        return ResponseEntity.ok(auctionService.tenEndingAuctions());
    }

    // TODO: 25.07.2023 obsluzyc metode z pokazywaniem 10 najnowszych aukcji serwisu,
    // TODO: 25.07.2023 stworzyc w serwisie i repozytorium metode wyszukujaca 10 konczacych sie aukcji, obsluzyc w kontrolerze


}
