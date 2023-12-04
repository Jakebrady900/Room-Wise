package com.roomwise.Strategy;

import com.roomwise.Models.Payment;

public interface PaymentStrategy {
    void executePayment(Payment payment);
}
