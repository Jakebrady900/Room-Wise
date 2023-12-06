package com.roomwise.Models;

public class BasicReceipt implements Receipt{
    @Override
    public String getDescription() {
        return "Basic Receipt";
    }

    @Override
    public double getCost() {
        return 10.0; // Basic cost
    } 
}
