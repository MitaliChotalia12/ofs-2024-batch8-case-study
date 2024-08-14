package com.ofss.main.inb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.inb.ServiceRepository.AccountService;
import com.ofss.main.inb.ServiceRepository.CustomerService;
import com.ofss.main.inb.domain.Account;
import com.ofss.main.inb.domain.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("inb-api")
public class INBController {
    
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @GetMapping("login")
    public String login(@RequestBody Customer customer){
        return customerService.login(customer.getCustomerLoginId(), customer.getCustomerPassword());
    }

    @PostMapping("register")
    public Customer register(@RequestBody Customer customer){
        return customerService.register(customer);
    }

    // @PostMapping("accountCreation")
    // public Account createAccount(@RequestBody Account account){
    //     return accountService.createAccount("savings", customer);
    // }

    @GetMapping("listaccounts/{id}")
    public List<Account> AccountList(@PathVariable int id){
        return accountService.getAllAccounts(id);
    }

    @PostMapping("AccountCreation")
	public String accCreation(@RequestBody Account account) {
		return accountService.AccRegister(account);
	}
}
