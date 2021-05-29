package com.studying.restapidemo.service.impl;

import com.studying.restapidemo.model.common.Account;
import com.studying.restapidemo.repo.AccountRepo;
import com.studying.restapidemo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public Account add(Account account) {
        Account accountInserted = null;
        try {
            accountInserted = accountRepo.save(account);
        } catch (Exception ex){
            log.error("add account fail");
        }

        return accountInserted;
    }

    @Override
    public boolean delete(long id) {
        try {
            accountRepo.deleteById(id);
            return true;
        }catch (Exception ex){
            log.error("can't delete!");
            return false;
        }
    }

    @Override
    public Account update(Account account) {
        Account accountUpdated = null;
        try {
            accountUpdated = accountRepo.save(account);
        } catch (Exception ex){
            log.error("update account fail");
        }

        return accountUpdated;
    }


}
