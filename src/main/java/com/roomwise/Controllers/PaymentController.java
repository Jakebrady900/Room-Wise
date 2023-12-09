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


@RestController 
@Controller
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Endpoint to handle payment creation
    @PostMapping("/makePayment")
    public String makePayment(@RequestBody Payment payment) {
        paymentService.makePayment(payment);
        return "Payment sucessful";
    }

    // Endpoint to retrieve all payments

    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayments() {
        return paymentService.showPayments();
    }

    // Endpoint to retrieve payment by ID

    @GetMapping("/getPayment/{paymentId}")
   public Payment getPaymentByID(@PathVariable("paymentId") int paymentId) {
    return paymentService.findPaymentById(paymentId);}

}
