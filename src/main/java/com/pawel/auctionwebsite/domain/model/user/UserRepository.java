package com.pawel.auctionwebsite.domain.model.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {
    User save(User user);
    User update(User user);
    User findByUuid(String uuid);
    Page<User> findAll(Pageable pageable);

}
