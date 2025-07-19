/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.HashMap;
import model.Booking;
import utils.MetaInfo;

/**
 *
 * @author Vitor
 */
public class BookingDAO implements DAO<Integer, Booking> {

    private HashMap<Integer, Booking> bookingData;
    private static BookingDAO instance;
    
    private BookingDAO() {
        bookingData = new HashMap();
    }
    
    public static BookingDAO getInstance() {
        if(instance == null) {
            instance = new BookingDAO();
        }
        return instance;
    }
    
    @Override
    public void create(Booking t) {
        t.setId(MetaInfo.bookingCount++);
        bookingData.put(t.getId(), t);
    }

    @Override
    public boolean read(Booking t) {
        return bookingData.containsValue(t);
    }

    @Override
    public boolean delete(Booking t) {
        bookingData.remove(t.getId());
        return true;
    }

    @Override
    public HashMap<Integer, Booking> readAll() {
       return bookingData;
    }

    @Override
    public Booking readById(int id) {
        return bookingData.get(id);
    }
    
    public boolean update(Booking t) {
        if(bookingData.containsKey(t.getId())) {
            bookingData.put(t.getId(), t);
            return true;
        }
        return false;
    }

    public HashMap<Integer, Booking> getBookingData() {
        return bookingData;
    }

    public void setBookingData(HashMap<Integer, Booking> bookingData) {
        this.bookingData = bookingData;
    }
}
