package com.roomwise.Services;

import com.roomwise.Models.Payment;
import com.roomwise.ObservePayments.Observer;
import com.roomwise.ObservePayments.Subject;
import com.roomwise.Repositories.PaymentDAO;
import com.roomwise.Strategy.PaymentStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements Subject{

    
    private PaymentDAO paymentRepository;
    private PaymentStrategy paymentStrategy;
    private List<Observer> observers = new ArrayList<>();
    private int reservationPaymentId;
    private boolean paymentStatus;// payment model

    public PaymentService(PaymentStrategy paymentStrategy, PaymentDAO paymentRepository) {
        this.paymentStrategy = paymentStrategy;
        this.paymentRepository = paymentRepository;

    }


    public void makePayment(Integer PaymentId) {
        Payment payment = paymentRepository.findById(PaymentId);
        payment.setPaymentStatus(true); // Integrate an external payment gateway here
        paymentStatus = payment.getPaymentStatus();
        paymentStrategy.executePayment(payment);
        reservationPaymentId = payment.getPaymentId();
        notifyObservers();
    }

    public List<Payment> showPayments() {
        return paymentRepository.findAll();
    }

    public Payment createPayment() {
        Payment payment = new Payment();
        paymentRepository.save(payment);
        return payment;
    }

   
    public Payment findPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId);
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("notifyObservers");
        for (Observer observer : observers) {
            if (((ReservationService) observer).getPaymentId() == reservationPaymentId) {
                observer.updatePaymentStatus(paymentStatus);
                System.out.println(((ReservationService) observer).getPaymentId());
            }
        }
    }

}