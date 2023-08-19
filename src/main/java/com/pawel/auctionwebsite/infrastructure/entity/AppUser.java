package com.pawel.auctionwebsite.infrastructure.entity;

import com.pawel.auctionwebsite.infrastructure.model.Address;
import com.pawel.auctionwebsite.infrastructure.model.Status;
import com.pawel.auctionwebsite.infrastructure.model.Type;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private String uuid;
    @OneToMany
    final List<Auction> observed= new ArrayList<>();
    @OneToMany
    final List<Auction> bid = new ArrayList<>();
    String nickname;
    String password;
    @Embedded
    Address address;
    Type type;
    Status status;
    LocalDateTime createdDate;
    LocalDateTime modificationDate;

    public AppUser(String nickname, String password, Address address, Type type, Status status, LocalDateTime createdDate) {
        this.nickname = nickname;
        this.password = password;
        this.address = address;
        this.type = type;
        this.status = status;
        this.createdDate = createdDate;
    }


    public AppUser(String uuid, String nickname, String password, Address address, Type type, Status status, LocalDateTime createdDate, LocalDateTime modificationDate) {
        this.uuid = uuid;
        this.nickname = nickname;
        this.password = password;
        this.address = address;
        this.type = type;
        this.status = status;
        this.createdDate = createdDate;
        this.modificationDate = modificationDate;
    }


}
// TODO: 25.07.2023 zrobic metody do dodania listy do obserwacji