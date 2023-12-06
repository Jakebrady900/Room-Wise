package com.roomwise.Repositories;

import com.roomwise.Models.Payment;
import com.roomwise.Models.Receipt;

import org.springframework.stereotype.Repository;

import java.util.List;
//import java.util.Optional;


@Repository

public class ReceiptDAO {
    public void save(Receipt receipt) {
    }

    public List<Payment> findAll() {
        return null;
    }

    // public Optional<Receipt> findById(Long paymentId) {
    //     return null;
    // }
    
}
