package com.roomwise.Decorator;
import com.roomwise.Models.Receipt;

public abstract class ReceiptDecorator implements Receipt {
    protected Receipt decoratedReceipt;

    public ReceiptDecorator(Receipt decoratedReceipt) {
        this.decoratedReceipt = decoratedReceipt;
    }

    @Override
    public String getDescription() {
        return decoratedReceipt.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedReceipt.getCost();
    }
}

//public interface ReceiptDecorator extends Receipt {
//public class ReceiptDecorator {
    
//}
