package com.pawel.auctionwebsite.api.dto.request;

import com.pawel.auctionwebsite.infrastructure.model.Address;
import lombok.Getter;

@Getter
public class UpdateUserRequest {
    String nickname;
    String password;
    Address address;
}
