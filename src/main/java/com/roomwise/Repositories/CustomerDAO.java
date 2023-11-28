package com.roomwise.Repositories;

import com.roomwise.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUsername(String username);
}
