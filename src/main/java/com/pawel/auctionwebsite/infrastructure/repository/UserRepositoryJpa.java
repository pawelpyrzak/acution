package com.pawel.auctionwebsite.infrastructure.repository;

import com.pawel.auctionwebsite.domain.model.user.User;
import com.pawel.auctionwebsite.infrastructure.entity.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJpa extends JpaRepository<UserDao, Long> {
    Optional<UserDao> findByUuid(String uuid);
}
