package com.pawel.auctionwebsite.api.controller;

import com.pawel.auctionwebsite.api.dto.request.UserRequest;
import com.pawel.auctionwebsite.api.dto.response.UserResponse;
import com.pawel.auctionwebsite.domain.model.user.Address;
import com.pawel.auctionwebsite.domain.model.user.User;
import com.pawel.auctionwebsite.domain.service.UserService;
import com.pawel.auctionwebsite.infrastructure.mapper.DtoMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    DtoMapper dtoMapper;
    UserService userService;
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        User user = userService.createUser(
                userRequest.getNickname(),
                userRequest.getPassword(),
                userRequest.getAddress(),
                userRequest.getType(),
                userRequest.getStatus());

       return ResponseEntity.ok(dtoMapper.mapToUserResponse(user));
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable String uuid,@RequestParam String nickname,
            @RequestParam String password,@RequestParam Address address){
        userService.updateUser(uuid, nickname, password, address);


    }

}
