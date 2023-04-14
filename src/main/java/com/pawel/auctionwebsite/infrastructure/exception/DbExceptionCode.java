package com.pawel.auctionwebsite.infrastructure.exception;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    @RequiredArgsConstructor
    public enum DbExceptionCode {
        NO_USER("There is no such user with passed uuid", 400);

        String message;
        int status;

        public String getMessage() {
            return message;
        }

        public int getStatus() {
            return status;
        }

        public DbException createDbException() {
            return new DbException(this);
        }
    }

