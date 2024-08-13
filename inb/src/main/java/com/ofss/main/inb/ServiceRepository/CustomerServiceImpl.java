package com.ofss.main.inb.ServiceRepository;

import com.ofss.main.inb.domain.Customer;
import com.ofss.main.inb.Repository.CustomerRepo;
import com.ofss.main.inb.Repository.CustomerRepoImpl;

public class CustomerServiceImpl implements CustomerService{

    CustomerRepo customerRepo = new CustomerRepoImpl();

    @Override
    public boolean register(Customer c) {
        return customerRepo.register(c);
    }

    @Override
    public String login(String loginID, String pwd) {
       return customerRepo.login(loginID, pwd);
    }
    
}
