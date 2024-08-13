package com.ofss.main.inb.domain;

public class Transaction {
    private int transaction_id;
    private int payee_account_id;
    private int payer_account_id;
    private int transaction_amount;
    private String transaction_status;
    private String transaction_remarks;
    private String transaction_created_at;
    private String transaction_completed_at;
    private String transfer_type;
    private String transaction_type;
    
    public int getTransaction_id() {
        return transaction_id;
    }
    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }
    public int getPayee_account_id() {
        return payee_account_id;
    }
    public void setPayee_account_id(int payee_account_id) {
        this.payee_account_id = payee_account_id;
    }
    public int getPayer_account_id() {
        return payer_account_id;
    }
    public void setPayer_account_id(int payer_account_id) {
        this.payer_account_id = payer_account_id;
    }
    public int getTransaction_amount() {
        return transaction_amount;
    }
    public void setTransaction_amount(int transaction_amount) {
        this.transaction_amount = transaction_amount;
    }
    public String getTransaction_status() {
        return transaction_status;
    }
    public void setTransaction_status(String transaction_status) {
        this.transaction_status = transaction_status;
    }
    public String getTransaction_remarks() {
        return transaction_remarks;
    }
    public void setTransaction_remarks(String transaction_remarks) {
        this.transaction_remarks = transaction_remarks;
    }
    public String getTransaction_created_at() {
        return transaction_created_at;
    }
    public void setTransaction_created_at(String transaction_created_at) {
        this.transaction_created_at = transaction_created_at;
    }
    public String getTransaction_completed_at() {
        return transaction_completed_at;
    }
    public void setTransaction_completed_at(String transaction_completed_at) {
        this.transaction_completed_at = transaction_completed_at;
    }
    public String getTransfer_type() {
        return transfer_type;
    }
    public void setTransfer_type(String transfer_type) {
        this.transfer_type = transfer_type;
    }
    public String getTransaction_type() {
        return transaction_type;
    }
    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }
    
}
