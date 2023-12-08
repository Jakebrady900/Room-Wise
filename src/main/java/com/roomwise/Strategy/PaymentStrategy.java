package com.roomwise.Strategy;

import com.roomwise.Models.Payment;
import org.springframework.stereotype.Component;

@Component
public interface PaymentStrategy {
    void executePayment(Payment payment);
}
