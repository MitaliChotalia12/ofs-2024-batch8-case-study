package com.ofss.main.inb.Repository;

import org.springframework.data.repository.CrudRepository;

// import org.springframework.data.repository.CrudRepository;

import com.ofss.main.inb.domain.Account;

// import com.ofss.main.domain.*;
// import java.util.*;

public interface AccountRepo extends CrudRepository<Account,Integer>{
    
}
