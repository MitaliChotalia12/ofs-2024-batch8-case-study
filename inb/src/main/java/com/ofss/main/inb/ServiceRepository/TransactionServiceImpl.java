package com.ofss.main.inb.ServiceRepository;

import com.ofss.main.inb.Repository.TransactionRepo;
import com.ofss.main.inb.Repository.TransactionRepoImpl;

public class TransactionServiceImpl implements TransactionService{
    private TransactionRepo transactionRepository = new TransactionRepoImpl();

        @Override
        public String moneyTransaction(int payee_account_id, int payer_account_id, int transactionAmount, String transactionType){
            return transactionRepository.moneyTransaction(payee_account_id, payer_account_id, transactionAmount, transactionType);
        }


}