package com.roomwise.Decorator;

import com.roomwise.Models.Receipt;

public class AdditionalItemDecorator extends ReceiptDecorator {
    public AdditionalItemDecorator(Receipt decoratedReceipt) {
        super(decoratedReceipt);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Additional Item";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.0; // Additional item cost
    }
}

