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
public class PaymentService {

    private PaymentDAO paymentRepository;
    private PaymentStrategy paymentStrategy;
    private ReservationService reservation;

    private List<Observer> observers = new ArrayList<>();
    private boolean paymentStatus;// payment model
    //  private long resID; // payment model yet to be connected to payment

    public PaymentService(PaymentStrategy paymentStrategy, PaymentDAO paymentRepository) {
        this.paymentStrategy = paymentStrategy;
        this.paymentRepository = paymentRepository;
        //this.reservation = reservation;
    }

    public void makePayment(Payment payment) {
        paymentStrategy.executePayment(payment);
        paymentRepository.save(payment);
        //reservation.addToObserver(this);
    }

    public List<Payment> showPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> findPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

//    @Override
//    public void addObserver(Observer newObserver) {
//        observers.add(newObserver);
//    }
//
//    @Override
//    public void removeObserver(Observer newObserver) {
//        int obIndex = observers.indexOf(newObserver);
//        observers.remove(obIndex);
//    }
//
//    @Override
//    public void notifyObservers() {
//
//        for (Observer observer : observers) {
//            observer.update(paymentStatus);
//        }
//
//    }

    public void setPaymentStatus(boolean newPStatus) {
        this.paymentStatus = newPStatus;
//        notifyObservers();
    }

}