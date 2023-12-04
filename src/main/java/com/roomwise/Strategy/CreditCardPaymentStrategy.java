package com.roomwise.Strategy;

import com.roomwise.Models.Payment;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void executePayment(Payment payment) {
        // credit card payment mock

        System.out.println("Processing credit card payment...");
    }
}