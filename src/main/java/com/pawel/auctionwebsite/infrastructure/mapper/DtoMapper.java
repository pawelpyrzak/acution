package com.pawel.auctionwebsite.infrastructure.mapper;

import com.pawel.auctionwebsite.api.dto.response.UserResponse;
import com.pawel.auctionwebsite.domain.model.user.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DtoMapper {


    @Mapping(source = "address.street", target = "address.street")
    @Mapping(source = "address.city", target = "address.city")
    @Mapping(source = "address.voivodeship", target = "address.voivodeship")
    @Mapping(source = "address.postcode", target = "address.postcode")
    @Mapping(source = "address.houseNumber", target = "address.houseNumber")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "status", target = "status")
    UserResponse mapToUserResponse(User user);

}

