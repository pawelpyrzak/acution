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
    @Mapping(source = "address.street", target = "street")
    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.voivodeship", target = "voivodeship")
    @Mapping(source = "address.postcode", target = "postcode")
    @Mapping(source = "address.houseNumber", target = "houseNumber")


    UserDao toUserDao(User user);
    @Mapping(source = "street", target = "address.street")
    @Mapping(source = "city", target = "address.city")
    @Mapping(source = "voivodeship", target = "address.voivodeship")
    @Mapping(source = "postcode", target = "address.postcode")
    @Mapping(source = "houseNumber", target = "address.houseNumber")

    User toUser(UserDao userDao);
}
