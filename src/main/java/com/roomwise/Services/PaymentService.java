package com.roomwise.Services;

import com.roomwise.Models.Payment;
import com.roomwise.Repositories.PaymentDAO;
import com.roomwise.Strategy.PaymentStrategy;
import com.roomwise.ObservePayments.Subject;
import com.roomwise.ObservePayments.Observer;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PaymentService implements Subject{

     @Autowired
    private PaymentDAO paymentRepository;
    private PaymentStrategy paymentStrategy;
    private ReservationService reservation;

    @Autowired
    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(Payment payment) {
        paymentStrategy.executePayment(payment);
        paymentRepository.save(payment);
        reservation.addToObserver(payment);
    }

    public List<Payment> showPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> findPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }


    @Override
    public void addObserver(Observer newObserver) {
       observers.add(newObserver);
    }

    @Override
    public void removeObserver(Observer newObserver) {
       int obIndex = observers.indexOf(newObserver);
        observers.remove(obIndex);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(paymentStatus);
        }

    }

    public void setPaymentStatus(boolean newPStatus){
        this.paymentStatus = newPStatus;
        notifyObservers();
    }

}
