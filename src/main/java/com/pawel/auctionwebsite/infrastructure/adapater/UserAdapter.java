package com.pawel.auctionwebsite.infrastructure.adapater;

import com.pawel.auctionwebsite.domain.model.user.User;
import com.pawel.auctionwebsite.domain.model.user.UserRepository;
import com.pawel.auctionwebsite.infrastructure.entity.UserDao;
import com.pawel.auctionwebsite.infrastructure.exception.DbExceptionCode;
import com.pawel.auctionwebsite.infrastructure.mapper.DaoMapper;
import com.pawel.auctionwebsite.infrastructure.repository.UserRepositoryJpa;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

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
        UserDao userDaoFromDb = getByUuid(user.getUuid());

        return daoMapper.toUser(userRepositoryJpa.save(new UserDao(userDaoFromDb.getId(), user.getUuid(),
                user.getNickname(), user.getPassword(), user.getAddress(), user.getType(),user.getStatus(),
                userDaoFromDb.getCreatedDate(), LocalDateTime.now())));
    }

    @Override
    public User findByUuid(String uuid) {
        return daoMapper.toUser(getByUuid(uuid));
    }

    private UserDao getByUuid(String uuid) {
        return userRepositoryJpa.findByUuid(uuid)
                .orElseThrow(DbExceptionCode.NO_USER::createDbException);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepositoryJpa.findAll(pageable)
                .map(daoMapper::toUser);
    }
}
