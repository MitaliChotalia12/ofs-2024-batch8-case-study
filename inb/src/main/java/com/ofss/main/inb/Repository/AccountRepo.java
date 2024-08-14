package com.ofss.main.inb.Repository;

import org.springframework.data.repository.CrudRepository;

// import org.springframework.data.repository.CrudRepository;

import com.ofss.main.inb.domain.Account;
import com.ofss.main.inb.domain.Customer;

// import com.ofss.main.domain.*;
// import java.util.*;
import java.util.List;


public interface AccountRepo extends CrudRepository<Account,Integer>{
    List<Account> findByCustomer(Customer customer);
}
