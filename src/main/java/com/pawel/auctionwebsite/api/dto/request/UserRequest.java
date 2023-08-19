package com.pawel.auctionwebsite.api.dto.request;

import com.pawel.auctionwebsite.infrastructure.model.Address;
import com.pawel.auctionwebsite.infrastructure.model.Status;
import com.pawel.auctionwebsite.infrastructure.model.Type;
import lombok.Getter;

@Getter
public class UserRequest {
    String nickname;
    String password;
    Address address;
    Type type;
    Status status;
}
