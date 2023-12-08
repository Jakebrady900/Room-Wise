package com.roomwise.ObservePayments;

// Interface to define the Subject (observable) behavior
public interface Subject {
    void addObserver(Observer observer); // Method to add an observer
    void removeObserver(Observer observer); // Method to remove an observer
    void notifyObservers(); // Method to notify all observers of changes
}