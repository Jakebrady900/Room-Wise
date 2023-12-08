package com.roomwise.Notification;


import com.roomwise.Models.Customer;

public interface InotificationCommand {
    String execute(Customer customer, String message);


}
