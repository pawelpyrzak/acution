package com.pawel.auctionwebsite.domain.service;

import com.pawel.auctionwebsite.infrastructure.HighestOffer;
import com.pawel.auctionwebsite.infrastructure.model.Promo;
import com.pawel.auctionwebsite.infrastructure.entity.Auction;
import com.pawel.auctionwebsite.infrastructure.entity.Category;
import com.pawel.auctionwebsite.infrastructure.repository.AuctionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class AuctionService {
    AuctionRepository auctionRepository;


    public Auction createAuction(String title, String description, Category category, BigDecimal instantPurchasePrice,
                                 boolean instantPurchase, BigDecimal minAmount, Promo promo, String location) {
        LocalDateTime now = LocalDateTime.now();
        Auction auction = new Auction(UUID.randomUUID().toString(), title, description, category, instantPurchasePrice,
                instantPurchase, minAmount, promo, location, now, now.plusMonths(1L), 0, null, true);

        return auctionRepository.save(auction);
    }

    public List<Auction> tenLatestAuctions (){
        Pageable topTen= PageRequest.of(0,10);
        return auctionRepository.tenLatestAuctions(topTen)
                .toList();
    }
    public List<Auction> tenEndingAuctions(){
        Pageable topTenEnd = PageRequest.of(0,10);
        return  auctionRepository.tenEndingAuctions(topTenEnd)
                .toList();
    }


}
