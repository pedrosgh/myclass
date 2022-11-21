package com.nttdata.myclass.service;

import com.nttdata.myclass.model.Account;

public interface IAccountService {
    Account validateLogin(Account account);
}
