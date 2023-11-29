package com.roomwise.Controllers;

import com.roomwise.Models.Payment;
//import com.roomwise.Models.Payment;
import com.roomwise.Services.PaymentService;
//import com.roomwise.Services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/makePayment")
    public String makePayment(@RequestBody Payment payment) {
        paymentService.makePayment(payment);
        return "saved sucessfully";
    }

    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayments() {
        return paymentService.showPayments();
    }

    @GetMapping("/getPayment/{id}")
    public String getReservationByID(@PathVariable Long Id) {
        if (paymentService.findPaymentById(Id).isPresent()) {
            return "Paid : " + paymentService.findPaymentById(Id).get();
        } else {
            return "no payment made";
        }
    }

}
