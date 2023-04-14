package com.pawel.auctionwebsite.domain.model.user;

public interface UserRepository {
    User save(User user);
    User update(User user);
    User findByUuid(String uuid);

}
