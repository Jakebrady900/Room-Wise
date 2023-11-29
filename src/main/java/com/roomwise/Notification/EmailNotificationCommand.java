package com.roomwise.Notification;

import com.roomwise.Models.Customer;

public class EmailNotificationCommand implements InotificationCommand {
    private Customer customer;
    private String message;

    public EmailNotificationCommand(Customer customer, String message) {
        this.customer = customer;
        this.message = message;
    }

    @Override
    public String execute() {
        // mockup of an email notification

        String returnString = "Email sent to " + customer.getEmail() + ": " + message;
        return returnString;
    }
}