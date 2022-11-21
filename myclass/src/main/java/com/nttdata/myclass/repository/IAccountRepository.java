package com.nttdata.myclass.repository;

import com.nttdata.myclass.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {
    Account findByUsernameAndPassword(String username, String password);
}
