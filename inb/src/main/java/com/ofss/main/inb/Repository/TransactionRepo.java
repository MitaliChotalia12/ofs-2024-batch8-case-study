package com.ofss.main.inb.Repository;

// import org.springframework.data.repository.CrudRepository;

// import com.ofss.main.inb.domain.Transaction;

public interface TransactionRepo{
    public String moneyTransaction(int payee_account_id, int payer_account_id, int transactionAmount, String transactionType);
}