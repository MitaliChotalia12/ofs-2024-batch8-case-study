package com.ofss.main.inb.ServiceRepository;

import java.util.List;

import com.ofss.main.inb.domain.Account;

public interface AdminService {
    public String AdminLogin(String AdminLoginID , String Adminpwd);
    public String unblock(String customerLoginId);
    public List<Account> getAccountId(int customerloginId);
    public String Approve(Account account);
}
