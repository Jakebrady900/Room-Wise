package com.roomwise.Models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


import com.roomwise.Services.IdService;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@Data
@AllArgsConstructor @NoArgsConstructor
public class Reservation {

	private Integer reservationId; // Unique identifier for a reservation

	private Integer customerId; // ID of the customer associated with the reservation

	private Integer paymentId; // ID of the payment linked to the reservation

	private LocalDate checkinDate; // Date of check-in for the reservation

	private LocalDate checkoutDate; // Date of check-out for the reservation

	private List<Integer> RoomsNumber; // List of room numbers associated with the reservation

	private boolean paymentStatus; // Status of the payment for the reservation


}