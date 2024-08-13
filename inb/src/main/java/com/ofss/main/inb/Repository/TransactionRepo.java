package com.ofss.main.inb.Repository;

public interface TransactionRepo {
    public String moneyTransaction(int payee_account_id, int payer_account_id, int transactionAmount, String transactionType);
}