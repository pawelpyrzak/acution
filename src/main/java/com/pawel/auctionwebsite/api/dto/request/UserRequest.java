package com.pawel.auctionwebsite.api.dto.request;

import com.pawel.auctionwebsite.domain.model.user.Address;
import com.pawel.auctionwebsite.domain.model.user.Status;
import com.pawel.auctionwebsite.domain.model.user.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserRequest {
    String nickname;
    String password;
    Address address;
    Type type;
    Status status;
}
