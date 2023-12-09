package com.roomwise.Repositories;


import com.roomwise.Models.Payment;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PaymentDAO {

    // In-memory database to store Payment objects
    List<Payment> PaymentDB = new ArrayList<>();


// Save method to add or update a payment in the database
public void save(Payment payment) {
         // Check if payment with the same paymentId already exists
        if(findById(payment.getPaymentId())!=null) {
            payment.setPaymentDate(LocalDate.now());    
            // Setting the payment date to the time when the payment was received If payment with the same paymentId exists, update it
            updatePayment(payment);

        }else{

            // If payment with the paymentId doesn't exist, add it to the database
            PaymentDB.add(payment);

        }
        //change this to a specific id payment instead of a new payment creation.

    }

    // Retrieve all payments from the database
    public List<Payment> findAll() {
        return PaymentDB;
    }

    // Find a payment by its paymentId
    public  Payment findById(int paymentId) {
        for(Payment payment : PaymentDB) {
            if(payment.getPaymentId() == paymentId) {
                return payment;
            }
        }
        // Return null if payment with the given paymentId is not found
        return null;
    }

    // Update an existing payment in the database
    public void updatePayment(Payment updatedPayment) {
        for (int i = 0; i < PaymentDB.size(); i++) {
            Payment payment = PaymentDB.get(i);
            if (payment.getPaymentId().equals(updatedPayment.getPaymentId())) {
                // Update the payment in the database
                PaymentDB.set(i, updatedPayment);
                // Updated successfully
            }
        }
         // If the item with the given paymentId is not found, no update is performed
        
    }
}


