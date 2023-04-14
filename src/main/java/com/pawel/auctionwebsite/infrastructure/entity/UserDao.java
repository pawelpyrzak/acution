package com.pawel.auctionwebsite.infrastructure.entity;
import com.pawel.auctionwebsite.domain.model.user.Status;
import com.pawel.auctionwebsite.domain.model.user.Type;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String uuid;
    String nickname;
    String password;
    String street;
    String city;
    String voivodeship;
    String postcode;
    String houseNumber;
    Type type;
    Status status;
    LocalDateTime createdDate;
    LocalDateTime modificationDate;
}
