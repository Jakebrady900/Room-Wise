package com.roomwise.Services;

import com.roomwise.Models.Payment;
import com.roomwise.Repositories.PaymentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

     @Autowired
    private PaymentDAO paymentRepository;

    public void savePayment(@RequestBody Payment payment) {
        paymentRepository.save(payment);
    }

    public List<Payment> showPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> findPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }
   
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    

}
