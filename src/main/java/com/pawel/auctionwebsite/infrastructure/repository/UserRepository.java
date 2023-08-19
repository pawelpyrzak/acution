package com.pawel.auctionwebsite.infrastructure.repository;

import com.pawel.auctionwebsite.infrastructure.entity.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUuid(String uuid);

    Page<AppUser> findAll(Pageable pageable);
}
