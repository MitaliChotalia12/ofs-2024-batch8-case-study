package com.ofss.main.inb.ServiceRepository;

import com.ofss.main.inb.domain.Account;
import com.ofss.main.inb.domain.Customer;
import java.util.List;

public interface AccountService {
    public String AccRegister(Account account);
    List<Account> getAllAccounts(int customer_id);
}