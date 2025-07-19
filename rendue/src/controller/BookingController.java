/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import model.Booking;
import model.DAO.BookingDAO;
import model.DAO.PersonDAO;
import model.Person;
import model.Property;

/**
 *
 * @author karen
 */
public class BookingController {

    public static void register(Person user, String tenantName, Property property, LocalDate checkIn, LocalDate checkOut, double totalPrice) throws IllegalArgumentException {
        
        if(totalPrice < 0) throw new IllegalArgumentException("Price cannot be less than zero");
        
        if(!isAvailable(property.getId(), checkIn, checkOut, -1)) throw new IllegalArgumentException("Booking not available at specified dates");
        
        Person u1 = PersonDAO.getInstance().readById(0);
        
        Booking booking = new Booking(u1, tenantName, property, checkIn,checkOut, totalPrice);
        
        
        BookingDAO.getInstance().create(booking);
    }

    public static boolean edit(Booking booking) throws IllegalArgumentException {
        
        if(booking.getTotalPrice() < 0) throw new IllegalArgumentException("Price cannot be less than zero");
        
        if(!isAvailable(booking.getProperty().getId(), booking.getCheckIn(), booking.getCheckOut(), booking.getId())) throw new IllegalArgumentException("Booking not available at specified dates");
        
        boolean isUpdated = BookingDAO.getInstance().update(booking);
        
        if (isUpdated == false) {
            throw new IllegalArgumentException("Error updating booking");
        }
        return true;
    }
    
    public static Booking showUnique(Booking booking) throws IllegalArgumentException {
        Booking b = BookingDAO.getInstance().readById(booking.getId());
        if (b == null) {
            throw new IllegalArgumentException("Booking not found");
        }
        return b;
    }

    public static boolean isAvailable(int propertyId, LocalDate checkin, LocalDate checkout, int bookingIdToIgnore) {
        
        Collection<Booking> bookingList = new ArrayList<>();
        
        BookingDAO.getInstance().getBookingData().values().forEach(booking -> {
            if(booking.getProperty().getId() == propertyId) {
                if(booking.getId() != bookingIdToIgnore){
                    bookingList.add(booking); 
                }
            }
        });

        for (Booking booking : bookingList) {
            LocalDate existingCheckin = booking.getCheckIn();
            LocalDate existingCheckout = booking.getCheckOut();

            boolean overlap = checkin.isBefore(existingCheckout) && checkout.isAfter(existingCheckin);

            if (overlap) {
                return false;
            }
        }

        return true;
    }
    
    public static boolean delete(int id) throws IllegalArgumentException {
        Booking booking = BookingDAO.getInstance().readById(id);
        
        boolean isDeleted = BookingDAO.getInstance().delete(booking);
        
        if (isDeleted == false) {
            throw new IllegalArgumentException("Error deleting booking");
        }
        return true;
    }
}
