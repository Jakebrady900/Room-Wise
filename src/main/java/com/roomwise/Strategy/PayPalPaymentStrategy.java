package com.roomwise.Strategy;

import com.roomwise.Models.Payment;
import org.springframework.stereotype.Component;

public class PayPalPaymentStrategy implements PaymentStrategy {

     // Implementation of the executePayment method for PayPal payments
    @Override
    public void executePayment(Payment payment) {
        // payment by Paypal mock
         // In a real-world scenario, this method would interact with the PayPal payment system


        System.out.println("Processing PayPal payment...");
    }
}
