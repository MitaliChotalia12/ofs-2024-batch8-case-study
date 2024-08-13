package com.ofss.main.inb.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.inb.Repository.*;
import com.ofss.main.inb.domain.Account;
import com.ofss.main.inb.domain.Customer;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepo accountRepository;

    @Override
    public Account createAccount(String type, Customer customer) {
        Account account = new Account();
        account.setAccountType(type);
        account.setAccountStatus("active");
        account.setCustomer(customer);
        return accountRepository.save(account);
    }

    
}
