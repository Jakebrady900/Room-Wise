package com.roomwise.Strategy;

import com.roomwise.Models.Payment;
import org.springframework.stereotype.Component;

public class PayPalPaymentStrategy implements PaymentStrategy {
    @Override
    public void executePayment(Payment payment) {
        // payment by Paypal mock

        System.out.println("Processing PayPal payment...");
    }
}
