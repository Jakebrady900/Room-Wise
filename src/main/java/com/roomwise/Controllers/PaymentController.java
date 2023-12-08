package com.roomwise.Controllers;

import com.roomwise.Models.Payment;
//import com.roomwise.Models.Payment;
import com.roomwise.Services.PaymentService;
//import com.roomwise.Services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController @Controller
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/makePayment/{paymentId}")
    public String makePayment(@PathVariable Integer paymentId) {
        paymentService.makePayment(paymentId);
        return "Payment sucessful";
    }

    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayments() {
        return paymentService.showPayments();
    }

    @GetMapping("/getPayment/{paymentId}")
   public Payment getPaymentByID(@PathVariable("paymentId") int paymentId) {return paymentService.findPaymentById(paymentId);}

}
