package com.pawel.auctionwebsite.infrastructure.mapper;

import com.pawel.auctionwebsite.domain.model.user.User;
import com.pawel.auctionwebsite.infrastructure.entity.UserDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DaoMapper {
    @Mapping(source = "uuid",target = "uuid")
    @Mapping(source = "nickname",target = "nickname")
    @Mapping(source = "password",target = "password")
    @Mapping(source = "address",target = "address")
    @Mapping(source = "type",target = "type")
    @Mapping(source = "status",target = "status")
    User toUser(UserDao userDao);

    @Mapping(source = "uuid",target = "uuid")
    @Mapping(source = "nickname",target = "nickname")
    @Mapping(source = "password",target = "password")
    @Mapping(source = "address",target = "address")
    @Mapping(source = "type",target = "type")
    @Mapping(source = "status",target = "status")
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modificationDate", ignore = true)
    UserDao toUserDao(User user);
}
