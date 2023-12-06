package com.roomwise.Services;

import com.roomwise.Models.Payment;
import com.roomwise.Models.Receipt;
//import com.roomwise.Models.Receipt;
//import com.roomwise.Repositories.PaymentDAO;
import com.roomwise.Repositories.ReceiptDAO;
//import com.roomwise.Strategy.PaymentStrategy;
import com.roomwise.Decorator.DiscountDecorator;

import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class ReceiptService {
    //private ReceiptDAO receiptRepository;
    public ReceiptService(DiscountDecorator discountDecorator, ReceiptDAO receiptRepository) {
        this.receiptRepository = receiptRepository;
        //this.reservation = reservation;
    }

    // public List<Receipt> showR() {
    //     return (List<Payment>) receiptRepository.findAll();
    // }

    public List<Receipt> showReceipt() {
        return null;
    }
}
