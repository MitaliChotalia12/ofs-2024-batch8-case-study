package com.ofss.main.inb.ServiceRepository;

public interface ChequeService {
    public String cheque(int payee_cheque_id, int payer_cheque_id, int cheque_amount);
}
