package com.pawel.auctionwebsite.domain.service;

import com.pawel.auctionwebsite.domain.model.user.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public User updateUser(String uuid, String nickname, String password, Address address) {
        User userFromDb = userRepository.findByUuid(uuid);
        String newNickname;
        String newPassword;
        Address newAddress;
        if (nickname!=null){
            newNickname=nickname;
        }else{
            newNickname=userFromDb.getNickname();
        }
        if(password!=null){
            newPassword= password;
        }else {
            newPassword= userFromDb.getPassword();
        }
        if (address!=null){
            newAddress= address;
        }else{
            newAddress=userFromDb.getAddress();
        }
        return userRepository.update(new User(userFromDb.getUuid(),newNickname, newPassword,
                newAddress, userFromDb.getType(), userFromDb.getStatus()));
    }
    public Page<User> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }

}
