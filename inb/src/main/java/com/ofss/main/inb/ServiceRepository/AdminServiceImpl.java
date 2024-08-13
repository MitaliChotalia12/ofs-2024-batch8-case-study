package com.ofss.main.inb.ServiceRepository;

import java.util.List;

import com.ofss.main.inb.Repository.AdminRepo;
import com.ofss.main.inb.Repository.AdminRepoImpl;
// import com.ofss.main.domain.Customer;
import com.ofss.main.inb.domain.Account;

public class AdminServiceImpl implements AdminService {
    AdminRepo adminRepo = new AdminRepoImpl();

    @Override
    public String AdminLogin(String AdminLoginID, String Adminpwd) {
       return adminRepo.AdminLogin(AdminLoginID, Adminpwd);
    }

    public String unblock(String customerLoginId){
        return adminRepo.unblock(customerLoginId);
    }

    @Override
    public String Approve(Account account) {
        return adminRepo.Approve(account);
    }

    @Override
    public List<Account> getAccountId(int customerloginId) {
        return adminRepo.getAccountId(customerloginId);
    }
}
