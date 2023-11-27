package com.roomwise.DTO;

public class payment {
    // Component interface representing the Payment
interface Payment {
    void makePayment(double amount);
}

// Concrete component representing the basic payment
class BasicPayment implements Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing basic payment of $" + amount);
    }
}

// Decorator abstract class
abstract class PaymentDecorator implements Payment {
    private Payment decoratedPayment;

    public PaymentDecorator(Payment decoratedPayment) {
        this.decoratedPayment = decoratedPayment;
    }

    @Override
    public void makePayment(double amount) {
        decoratedPayment.makePayment(amount);
    }
}

// Concrete decorator class for adding additional functionality
class DiscountedPaymentDecorator extends PaymentDecorator {
    private double discountPercentage;

    public DiscountedPaymentDecorator(Payment decoratedPayment, double discountPercentage) {
        super(decoratedPayment);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void makePayment(double amount) {
        double discountedAmount = amount - (amount * discountPercentage / 100);
        System.out.println("Applying a " + discountPercentage + "% discount.");
        super.makePayment(discountedAmount);
    }
}

// HotelReservation class using the Payment class
class HotelReservation {
    private int reservationId;
    private double amount;
    private Payment payment;

    public HotelReservation(int reservationId, double amount, Payment payment) {
        this.reservationId = reservationId;
        this.amount = amount;
        this.payment = payment;
    }

    public void processPayment() {
        payment.makePayment(amount);
    }
}

// Example usage
public class HotelReservationSystem {
    public static void main(String[] args) {
        // Create a basic payment
        Payment basicPayment = new BasicPayment();

        // Decorate the basic payment with a discount
        Payment discountedPayment = new DiscountedPaymentDecorator(basicPayment, 10.0);

        // Create a hotel reservation with the decorated payment
        HotelReservation reservation = new HotelReservation(1, 200.0, discountedPayment);

        // Process payment
        reservation.processPayment();
    }
}

}
