package com.pawel.auctionwebsite.domain.service;

import com.pawel.auctionwebsite.domain.model.user.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class UserService {
    UserRepository userRepository;
    public User createUser(String nickname,String password,Address address,Type type,Status status){

        return userRepository.save(new User(UUID.randomUUID().toString(),nickname, password, address, type, status));
    }

//    public User updateUser(String uuid, String nickname, String password, Address address) {
//        User byUuid = userRepository.findByUuid(uuid);
//
//        //sprawdz czy nickname jest nullem, jezeli nie jest nullem to uzyj go w konstruktorze do toSave, jezeli jest nullem uzyj
//        //zmiennej z byUuid- tak samo dla pozostalych(nickname, password, address)
//        User toSave = new User()
//    }
}
