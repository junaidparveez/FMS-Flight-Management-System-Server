package com.flightbooking.app.booking;

import com.flightbooking.app.flight.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;

//    public Booking createBooking(int bookingId,int flightId,int passengerId,String paymentStatus){
//        Booking booking=new Booking();
////        return bookingRepo.save(Booking);
//    }


}
