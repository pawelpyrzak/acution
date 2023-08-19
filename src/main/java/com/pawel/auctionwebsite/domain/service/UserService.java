package com.pawel.auctionwebsite.domain.service;

import com.pawel.auctionwebsite.infrastructure.entity.AppUser;
import com.pawel.auctionwebsite.infrastructure.model.Address;
import com.pawel.auctionwebsite.infrastructure.model.Status;
import com.pawel.auctionwebsite.infrastructure.model.Type;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.pawel.auctionwebsite.infrastructure.repository.UserRepository;

import java.time.LocalDateTime;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class UserService {
    UserRepository userRepository;
    public AppUser createUser(String nickname, String password, Address address, Type type, Status status){

        return userRepository.save(new AppUser(nickname, password, address, type, status, LocalDateTime.now()));
    }

    public AppUser updateUser(String uuid, String nickname, String password, Address address) {
        AppUser appUserFromDb = userRepository.findByUuid(uuid).orElseThrow();

        String newNickname = (nickname != null) ? nickname : appUserFromDb.getNickname();
        String newPassword = (password != null) ? password : appUserFromDb.getPassword();
        Address newAddress = (address != null) ? address : appUserFromDb.getAddress();

        appUserFromDb.setNickname(newNickname);
        appUserFromDb.setPassword(newPassword);
        appUserFromDb.setAddress(newAddress);
        appUserFromDb.setModificationDate(LocalDateTime.now());

        return userRepository.save(appUserFromDb);
    }
    public Page<AppUser> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }

}
