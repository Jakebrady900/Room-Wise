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

    // Dependencies
    private PaymentDAO paymentRepository;
    private PaymentStrategy paymentStrategy;
    // Observers for payment status changes
    private List<Observer> observers = new ArrayList<>(); // List to hold observers
    // Fields to store reservation-related information
    private int reservationPaymentId;
    private boolean paymentStatus; // payment model

    // Constructor to initialize dependencies
    public PaymentService(PaymentStrategy paymentStrategy, PaymentDAO paymentRepository) {
        this.paymentStrategy = paymentStrategy;
        this.paymentRepository = paymentRepository;
    }

    // Method to process a payment
    public void makePayment(Payment payment) {
        // Get payment status locally for the observer
        paymentStatus = payment.getPaymentStatus(); 
        // Execute payment based on the strategy
        paymentStrategy.executePayment(payment); 
        //Creating a local variable to store the reservation paymentID to be used when observers are notified
        reservationPaymentId = payment.getPaymentId(); 
        // Save payment details
        paymentRepository.save(payment); 
        // Notify observers about the payment status change
        notifyObservers(); 
    }

    // Retrieve all payments from the repository
    public List<Payment> showPayments() {
        return paymentRepository.findAll();
    }

    // Find a payment by its paymentId
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
