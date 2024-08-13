package com.ofss.main.inb.ServiceRepository;

import com.ofss.main.inb.domain.Account;
import com.ofss.main.inb.domain.Customer;

public interface AccountService {
    public Account createAccount(String type, Customer customer);
}