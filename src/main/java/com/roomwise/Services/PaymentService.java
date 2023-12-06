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
    private ReservationService reservation;

    private List<Observer> observers = new ArrayList<>();
    private boolean paymentStatus;// payment model

    public PaymentService(PaymentStrategy paymentStrategy, PaymentDAO paymentRepository) {
        this.paymentStrategy = paymentStrategy;
        this.paymentRepository = paymentRepository;

    }

    public void makePayment(Payment payment) {
        paymentStrategy.executePayment(payment);
        paymentRepository.save(payment);
        notifyObservers(); // Notify observers about the payment status change
    }

    public List<Payment> showPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> findPaymentById(Long paymentId) {
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
        for (Observer observer : observers) {
            observer.updatePaymentStatus(paymentStatus);
        }
    }

}