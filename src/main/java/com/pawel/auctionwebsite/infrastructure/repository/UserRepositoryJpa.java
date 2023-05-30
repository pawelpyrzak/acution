package com.pawel.auctionwebsite.infrastructure.repository;

import com.pawel.auctionwebsite.infrastructure.entity.UserDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJpa extends JpaRepository<UserDao, Long> {
    Optional<UserDao> findByUuid(String uuid);

    Page<UserDao> findAll(Pageable pageable);
}
