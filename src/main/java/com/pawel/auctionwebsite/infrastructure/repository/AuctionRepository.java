package com.pawel.auctionwebsite.infrastructure.repository;

import com.pawel.auctionwebsite.infrastructure.entity.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    @Query("select a from Auction a order by a.dateOfIssue desc")
    Page<Auction> tenLatestAuctions(Pageable pageable);
    @Query("select a from Auction a order by a.endDate desc")
    Page<Auction> tenEndingAuctions(Pageable topTenEnd);
}
