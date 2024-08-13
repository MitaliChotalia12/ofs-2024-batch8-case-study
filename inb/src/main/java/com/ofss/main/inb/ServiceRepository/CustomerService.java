package com.ofss.main.inb.ServiceRepository;

import com.ofss.main.inb.domain.Customer;

public interface CustomerService {
    public boolean register(Customer c);
    public String login(String loginID , String pwd);
}
