package com.pawel.auctionwebsite.api.controller;

import com.pawel.auctionwebsite.api.dto.request.UpdateUserRequest;
import com.pawel.auctionwebsite.api.dto.request.UserRequest;
import com.pawel.auctionwebsite.api.dto.response.UserResponse;
import com.pawel.auctionwebsite.domain.model.user.Address;
import com.pawel.auctionwebsite.domain.model.user.User;
import com.pawel.auctionwebsite.domain.service.UserService;
import com.pawel.auctionwebsite.infrastructure.mapper.DtoMapper;
import com.pawel.auctionwebsite.infrastructure.repository.UserRepositoryJpa;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    DtoMapper dtoMapper;
    UserService userService;
    private final UserRepositoryJpa userRepositoryJpa;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
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
            @PathVariable String uuid, @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(dtoMapper.mapToUserResponse(userService.updateUser(uuid, request.getNickname(),
                request.getPassword(), request.getAddress())));
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(pageable)
                .map(dtoMapper::mapToUserResponse));
    }
}
