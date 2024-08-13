package com.ofss.main.inb.ServiceRepository;

import com.ofss.main.inb.Repository.*;

public class AccountServiceImpl implements AccountService{

    private AccountRepo accountRepository = new AccountRepoImpl();

    @Override
    public String AccountType(int customerId, String accountType, int overdraft_amount) {
       return accountRepository.AccountType(customerId, accountType, overdraft_amount);
    }
}
