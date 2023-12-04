package com.roomwise.Repositories;


import com.roomwise.Models.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class PaymentDAO {

    public void save(Payment payment) {
    }

    public List<Payment> findAll() {
        return null;
    }

    public Optional<Payment> findById(Long paymentId) {
        return null;
    }
}


