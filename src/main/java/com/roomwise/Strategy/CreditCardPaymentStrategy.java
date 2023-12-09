package com.roomwise.Strategy;

import com.roomwise.Models.Payment;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy {

    // Implementation of the executePayment method for credit card payments

    @Override
    public void executePayment(Payment payment) {
        // credit card payment mock 
        
        // In a real-world scenario, this method would interact with a credit card processing system


        System.out.println("Processing credit card payment...");
    }
}
