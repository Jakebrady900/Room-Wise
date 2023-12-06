package com.roomwise.Models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


import com.roomwise.Services.IdService;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class Reservation {

	private Integer reservationId;

	private Integer customerId;

	private Integer paymentId;

	private LocalDate checkinDate;

	private LocalDate checkoutDate;

	private Integer noOfPerson;

	private Integer noOfRooms;

	private List<Integer> RoomsNumber;

	private boolean paymentStatus;

	public Reservation(Customer customer) {
		customerId = customer.getCustomerId();
		this.reservationId = IdService.getNextReservationID();
	}



    //need a type to determine role
	//connect to rest of the app rooms/customer


}
