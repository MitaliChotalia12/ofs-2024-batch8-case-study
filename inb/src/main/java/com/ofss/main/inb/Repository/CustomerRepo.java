package com.ofss.main.inb.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.inb.domain.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Integer>{
    // public boolean register(Customer c);
    // public String login(String loginID , String pwd);
    List<Customer> findBycustomerLoginId(String customerLoginId);
}
