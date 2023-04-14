package com.pawel.auctionwebsite.api.dto.response;

import com.pawel.auctionwebsite.domain.model.user.Address;
import com.pawel.auctionwebsite.domain.model.user.Status;
import com.pawel.auctionwebsite.domain.model.user.Type;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class UserResponse {
    String uuid;
    String nickname;
    Address address;
    Type type;
    Status status;
}
