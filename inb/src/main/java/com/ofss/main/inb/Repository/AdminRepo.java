package com.ofss.main.inb.Repository;

import java.util.List;

// import org.springframework.data.repository.CrudRepository;

import com.ofss.main.inb.domain.Account;
// import com.ofss.main.inb.domain.Admin;

public interface AdminRepo{
    public String AdminLogin(String AdminLoginID , String Adminpwd);
    public String unblock(String customerLoginId);

    public List<Account> getAccountId(int customerloginId);
    public String Approve(Account account);
}
