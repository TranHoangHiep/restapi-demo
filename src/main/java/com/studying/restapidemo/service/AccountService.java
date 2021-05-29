package com.studying.restapidemo.service;

import com.studying.restapidemo.model.common.Account;

public interface AccountService {
    Account add(Account account);

    boolean delete(long id);

    Account update(Account account);

}
