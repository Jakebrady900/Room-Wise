package com.roomwise.Repositories;


import com.roomwise.Models.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PaymentDAO {

    List<Payment> PaymentDB = new ArrayList<>();



    public void save(Payment payment) {
        PaymentDB.add(payment);
    }

    public List<Payment> findAll() {
        return PaymentDB;
    }

    public  Payment findById(int paymentId) {
        for(Payment payment : PaymentDB) {
            if(payment.getPaymentId() == paymentId) {
                return payment;
            }
        }
        return null;
    }
}


