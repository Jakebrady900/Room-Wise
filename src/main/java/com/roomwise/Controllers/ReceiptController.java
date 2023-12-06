package com.roomwise.Controllers;

import com.roomwise.Models.Receipt;
import com.roomwise.Services.ReceiptService;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController @Controller
@RequestMapping("/receipt")
public class ReceiptController { //ReceiptController ReceiptService receipt
    
    

    private ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    // @PostMapping("/makePayment")
    // public String makePayment(@RequestBody Payment payment) {
    //     paymentService.makePayment(payment);
    //     return "Payment sucessful";
    // }

    @GetMapping("/getAllPayment")
    public List<Receipt> getAllPayments() {
        return receiptService.showReceipt();
    }

    // @GetMapping("/getPayment/{id}")
    // public String getReservationByID(@PathVariable Long Id) {
    //     if (paymentService.findPaymentById(Id).isPresent()) {
    //         return "Paid : " + paymentService.findPaymentById(Id).get();
    //     } else {
    //         return "no payment made";
    //     }
    // }
    
}
