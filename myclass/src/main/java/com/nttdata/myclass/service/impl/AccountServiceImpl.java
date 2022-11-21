package com.nttdata.myclass.service.impl;

import com.nttdata.myclass.model.Account;
import com.nttdata.myclass.repository.IAccountRepository;
import com.nttdata.myclass.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Account validateLogin(Account account) {
        Account acc = accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword());
        if(acc != null) {
            return acc;
        }
        return null;
    }
}
