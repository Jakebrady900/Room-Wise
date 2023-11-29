package com.roomwise.Repositories;


import com.roomwise.Models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface PaymentDAO extends JpaRepository<Payment, Long> {

}
    

