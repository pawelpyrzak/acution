package com.pawel.auctionwebsite.domain.model.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@Setter
public class User {
    String uuid;
    String nickname;
    String password;
    Address address;
    Type type;
    Status status;
}
