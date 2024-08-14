package com.ofss.main.inb.ServiceRepository;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ofss.main.inb.Repository.*;
import com.ofss.main.inb.domain.Account;
import com.ofss.main.inb.domain.Customer;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepo accountRepository;

    @Autowired
    private CustomerRepo customerRepo;

    // @Override
    // public Account createAccount(String type, Customer customer) {
    //     Account account = new Account();
    //     account.setAccountType(type);
    //     account.setAccountStatus("active");
    //     account.setCustomer(customer);
    //     return accountRepository.save(account);
    // }

    @Override
    public List<Account> getAllAccounts(int customer_id) {
        Optional<Customer> cusOptional = customerRepo.findById(customer_id);
        if(cusOptional.isPresent()){
            Customer customer = cusOptional.get();
            List<Account> accounts = accountRepository.findByCustomer(customer);
            return accounts;
        }


        return null;
    }

    @Override
    public String AccRegister(Account account) {
        try {
			Optional<Customer> optionalCust = customerRepo.findById(account.getCustomer().getCustomerId());
			Customer customer = optionalCust.get();
			account.setCustomer(customer);
			accountRepository.save(account);
            System.out.println("register true");
            return "true";  // Registration successful
        } catch (DataAccessException e) {
            // Log the exception
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Error occurred while Creating Account: ", e);
            return "false";  // Registration failed
        } catch (Exception e) {
            // Log unexpected exceptions
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("Unexpected error occurred while Creating Account: ", e);
            System.out.println(account);
            return "false";  // Registration failed
        }
    }

    
}
