package com.pawel.auctionwebsite.infrastructure.adapater;

import com.pawel.auctionwebsite.domain.model.user.User;
import com.pawel.auctionwebsite.domain.model.user.UserRepository;
import com.pawel.auctionwebsite.infrastructure.exception.DbExceptionCode;
import com.pawel.auctionwebsite.infrastructure.mapper.DaoMapper;
import com.pawel.auctionwebsite.infrastructure.repository.UserRepositoryJpa;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Repository
@RequiredArgsConstructor
public class UserAdapter implements UserRepository {
    UserRepositoryJpa userRepositoryJpa;
    DaoMapper daoMapper;
    @Override
    public User save(User user) {
         userRepositoryJpa.save(daoMapper.toUserDao(user));
         return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findByUuid(String uuid) {
        return daoMapper.toUser( userRepositoryJpa.findByUuid(uuid)
        .orElseThrow(DbExceptionCode.NO_USER::createDbException));
    }
}
