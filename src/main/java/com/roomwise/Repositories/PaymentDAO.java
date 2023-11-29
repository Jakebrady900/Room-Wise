package com.roomwise.Repositories;


import com.roomwise.Models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface PaymentDAO extends JpaRepository<Payment, Long> {

    Optional<Payment> findByPaymentId(String paymentid);
}
    

