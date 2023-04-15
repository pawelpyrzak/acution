package com.pawel.auctionwebsite.infrastructure.entity;

import com.pawel.auctionwebsite.domain.model.user.Address;
import com.pawel.auctionwebsite.domain.model.user.Status;
import com.pawel.auctionwebsite.domain.model.user.Type;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    Long id;
    String uuid;
    String nickname;
    String password;
    @Embedded
    Address address;
    Type type;
    Status status;
    LocalDateTime createdDate;
    LocalDateTime modificationDate;
}
