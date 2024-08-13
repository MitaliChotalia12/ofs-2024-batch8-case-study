package com.ofss.main.inb.ServiceRepository;

import com.ofss.main.inb.domain.Account;
import com.ofss.main.inb.domain.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.inb.Repository.CustomerRepo;
// import com.ofss.main.inb.Repository.CustomerRepoImpl;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AccountService accountService;

    // @Override
    // public boolean register(Customer c) {
    //     return customerRepo.register(c);
    // }

    @Override
    public String login(String loginID, String pwd) {
       List<Customer> customers = customerRepo.findBycustomerLoginId(loginID);
       if(customers.isEmpty()){
        return "false";
       }
       else{
        if(customers.get(0).getCustomerPassword().equals(pwd)){
            return "true";
        }
        else{
            Customer customer = customers.get(0);
            customer.setLoginAttempts(customer.getLoginAttempts()+1);

            if(customer.getLoginAttempts() == 3){
                customer.setCustomerStatus("inactive");
            }
            customerRepo.save(customer);
            return "false";
        }
       }
    }

    @Override
    public Customer register(Customer c) {

        Customer customer = customerRepo.save(c);
        Account account = accountService.createAccount("savings", customer);
        return customer;
    }
    
}
