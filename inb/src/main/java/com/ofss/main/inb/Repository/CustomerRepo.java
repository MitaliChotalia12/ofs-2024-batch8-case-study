package com.ofss.main.inb.Repository;

import com.ofss.main.inb.domain.Customer;

public interface CustomerRepo {
    public boolean register(Customer c);
    public String login(String loginID , String pwd);
}
