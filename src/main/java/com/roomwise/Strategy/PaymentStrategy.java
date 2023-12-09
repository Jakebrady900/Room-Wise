
package com.roomwise.Strategy;

import com.roomwise.Models.Payment;
import org.springframework.stereotype.Component;

@Component
public interface PaymentStrategy {

    // Interface defining a strategy for executing payments
    // Concrete implementations will provide specific payment processing logic

    // Method signature for executing a payment
    void executePayment(Payment payment);
}