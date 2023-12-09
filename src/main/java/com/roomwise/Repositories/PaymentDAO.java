package com.roomwise.Repositories;


import com.roomwise.Models.Payment;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PaymentDAO {

    List<Payment> PaymentDB = new ArrayList<>();



public void save(Payment payment) {
        if(findById(payment.getPaymentId())!=null) {
            payment.setPaymentDate(LocalDate.now());    // Setting the payment date to the time when the payment was received
            updatePayment(payment);
        }else{
            PaymentDB.add(payment);
        }//change this to a specific id payment instead of a new payment creation.

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

    public void updatePayment(Payment updatedPayment) {
        for (int i = 0; i < PaymentDB.size(); i++) {
            Payment payment = PaymentDB.get(i);
            if (payment.getPaymentId().equals(updatedPayment.getPaymentId())) {
                PaymentDB.set(i, updatedPayment);
                // Updated successfully
            }
        }
        // Item not found
    }
}


