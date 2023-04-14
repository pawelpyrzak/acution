package com.pawel.auctionwebsite.domain.model.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    String uuid;
    String nickname;
    String password;
    Address address;
    Type type;
    Status status;

}
