package com.ofss.main.inb.ServiceRepository;

public interface TransactionService {
    public String moneyTransaction(int payee_account_id, int payer_account_id, int transactionAmount, String transactionType);
}
