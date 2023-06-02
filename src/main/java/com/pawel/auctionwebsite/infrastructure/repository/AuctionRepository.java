package com.pawel.auctionwebsite.infrastructure.repository;

import com.pawel.auctionwebsite.infrastructure.entity.AuctionDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionDao, Long> {
}
