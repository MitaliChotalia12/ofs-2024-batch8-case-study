package com.ofss.main.inb.domain;

import java.time.LocalDate;

public class Cheque {

    private int id;
    private String status;
    private String payee_acc;
    private String payer_acc;
    private double amount;
    private LocalDate date;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPayee_acc() {
        return payee_acc;
    }
    public void setPayee_acc(String payee_acc) {
        this.payee_acc = payee_acc;
    }
    public String getPayer_acc() {
        return payer_acc;
    }
    public void setPayer_acc(String payer_acc) {
        this.payer_acc = payer_acc;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getDate() {
        return date.toString();
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    
}
