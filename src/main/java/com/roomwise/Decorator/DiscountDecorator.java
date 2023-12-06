package com.roomwise.Decorator;

import com.roomwise.Models.Receipt;

public class DiscountDecorator extends ReceiptDecorator {
    public DiscountDecorator(Receipt decoratedReceipt) {
        super(decoratedReceipt);
        
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Discount Applied";
    }

    @Override
    public double getCost() {
        return super.getCost() * 0.9; // 10% discount
    }
}

