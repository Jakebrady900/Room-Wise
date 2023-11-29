package com.roomwise.Services;

import com.roomwise.Models.Payment;
import com.roomwise.Repositories.PaymentDAO;
import com.roomwise.Strategy.PaymentStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

     @Autowired
    private PaymentDAO paymentRepository;
    private PaymentStrategy paymentStrategy;

    @Autowired
    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment( Payment payment) {
        paymentStrategy.executePayment(payment);
        paymentRepository.save(payment);
    }

    public List<Payment> showPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> findPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }
   


    

}
