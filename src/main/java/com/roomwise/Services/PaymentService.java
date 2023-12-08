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
public class PaymentService implements Subject {

    private PaymentDAO paymentRepository;
    private PaymentStrategy paymentStrategy;
    private List<Observer> observers = new ArrayList<>(); // List to hold observers
    private int reservationPaymentId;
    private boolean paymentStatus;

    public PaymentService(PaymentStrategy paymentStrategy, PaymentDAO paymentRepository) {
        this.paymentStrategy = paymentStrategy;
        this.paymentRepository = paymentRepository;
    }

    // Method to process a payment
    public void makePayment(Payment payment) {
        paymentStatus = payment.getPaymentStatus(); // Get payment status locally for the observer
        paymentStrategy.executePayment(payment); // Execute payment based on the strategy
        reservationPaymentId = payment.getPaymentId(); //Creating a local variable to store the reservation paymentID to be used when observers are notified
        paymentRepository.save(payment); // Save payment details
        notifyObservers(); // Notify observers about the payment status change
    }

    public List<Payment> showPayments() {
        return paymentRepository.findAll();
    }

    public Payment findPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId);
    }

    // Method to add an observer to the list
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Method to remove an observer from the list
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Method to notify all observers about the payment status change
    @Override
    public void notifyObservers() {
        System.out.println("notifyObservers");
        for (Observer observer : observers) {
            // Check if observer's payment ID matches the current reservation's payment ID
            if (((ReservationService) observer).getPaymentId() == reservationPaymentId) {
                // Update observer with the payment status
                observer.updatePaymentStatus(paymentStatus);
                System.out.println(((ReservationService) observer).getPaymentId());
            }
        }
    }
}
