package com.pawel.auctionwebsite.infrastructure.mapper;

import com.pawel.auctionwebsite.infrastructure.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DaoMapper {
//    @Mapping(source = "uuid",target = "uuid")
//    @Mapping(source = "nickname",target = "nickname")
//    @Mapping(source = "password",target = "password")
//    @Mapping(source = "address",target = "address")
//    @Mapping(source = "type",target = "type")
//    @Mapping(source = "status",target = "status")
    AppUser toUser(AppUser appUserDao);

//    @Mapping(source = "uuid",target = "uuid")
//    @Mapping(source = "nickname",target = "nickname")
//    @Mapping(source = "password",target = "password")
//    @Mapping(source = "address",target = "address")
//    @Mapping(source = "type",target = "type")
//    @Mapping(source = "status",target = "status")
//    @Mapping(target = "createdDate", ignore = true)
//    @Mapping(target = "modificationDate", ignore = true)
    AppUser toUserDao(AppUser appUser);
}
