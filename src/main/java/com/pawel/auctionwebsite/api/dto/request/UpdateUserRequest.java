package com.pawel.auctionwebsite.api.dto.request;

import com.pawel.auctionwebsite.domain.model.user.Address;
import lombok.Getter;

@Getter
public class UpdateUserRequest {
    String nickname;
    String password;
    Address address;
}
