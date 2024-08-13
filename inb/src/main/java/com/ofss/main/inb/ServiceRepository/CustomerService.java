package com.ofss.main.inb.ServiceRepository;

// import org.springframework.stereotype.Service;

import com.ofss.main.inb.domain.Customer;
public interface CustomerService {
    public String login(String loginID , String pwd);
    public Customer register(Customer customer);
}
