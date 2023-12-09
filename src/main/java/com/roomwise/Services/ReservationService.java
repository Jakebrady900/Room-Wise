package com.roomwise.Services;

import com.roomwise.Models.Payment;
import com.roomwise.Models.Reservation;
import com.roomwise.Models.Room;
import com.roomwise.ObservePayments.Observer;
import com.roomwise.Repositories.ReservationDAO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService implements Observer {

    private ReservationDAO reservationRepository;

//    private Reservation reservation;
    private PaymentService paymentService;
    private boolean paymentStatus;
    private Integer paymentId;
    private RoomService roomService;
    private CustomerService customerService;

    // Constructor injecting dependencies
    public ReservationService(ReservationDAO reservationRepository, PaymentService paymentService,RoomService roomService, CustomerService customerService) {
        this.reservationRepository = reservationRepository;
        this.paymentService = paymentService;
        this.paymentService.addObserver(this); // Subscribe to payment observer
        this.roomService = roomService;
        this.customerService = customerService;
    }
    //returns a non null value if there is no such reservation
    public Integer getPaymentId() {
        return this.paymentId != null ? this.paymentId : 0; // Return a default value if paymentId is null
    }

    //Saves the reservation
    public String saveReservation(Reservation reservation) {
        if (customerService.isValidCustomer(reservation.getCustomerId())) {
            if (isRoomAvailable(reservation.getRoomsNumber(), reservation.getCheckinDate())) {
                reservation.setReservationId(IdService.getNextReservationID());
                reservation.setPaymentId(IdService.getNextPaymentID());
                this.paymentId = reservation.getPaymentId();
                this.reservation = reservation;
                Payment payment = new Payment(paymentId);
                paymentService.makePayment(payment); // Process payment for the reservation
                reservationRepository.save(reservation); // Save reservation details
                return "Reservation created successfully for Customer" + reservation.getCustomerId();
            }
            return "Reservation not created, rooms not available ";
        }
        return "Reservation not created, Customer not found. create a new customer at /customer/reservation";
    }
    //To update the reservation
    public Boolean updateReservation(Reservation reservation) {
        return reservationRepository.updateReservation(reservation);
    }
    //Returns all the reservations
    public List<Reservation> showReservations() {
        return reservationRepository.getReservations();
    }
    //Returns the reservation for the specified ID
    public Reservation findReservationById(int reservationId) {
        return reservationRepository.findById(reservationId);
    }
    //Cancel a reservation with the specified ID
    public String cancelReservation(int reservationId) {
        return reservationRepository.deleteReservationById(reservationId);
    }

    // Observer method to update payment status
    @Override
    public void updatePaymentStatus(boolean status) {
        reservation.setPaymentStatus(status);
        // Update payment status in the reservation
        //this method is called when the payment status changes
    }

    //fetches the charge for the reservation
    public BigDecimal getCharge(Integer reservationId) {
        return reservationRepository.getCharge(reservationId);
    }

    // Check if rooms are available for reservation on a given date
    public boolean isRoomAvailable(List<Integer> roomIds, LocalDate Qdate) {
        List<Reservation> reservations = showReservations();
        for (Reservation reservation : reservations) {
            for (Integer roomId : roomIds) {
                if (reservation.getRoomsNumber().contains(roomId)) {
                    if (reservation.getCheckinDate().isBefore(Qdate) && reservation.getCheckoutDate().isAfter(Qdate)) {
                        return false; // Room not available for the specified date
                    }
                }
            }
        }
        return true; // Rooms available for the specified date
    }
}
