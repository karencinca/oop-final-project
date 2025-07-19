/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.BookingController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.Booking;
import model.DAO.BookingDAO;
import model.DAO.PersonDAO;
import model.DAO.PropertyDAO;
import model.Person;
import model.Property;

/**
 *
 * @author vitor
 */
public class BookingView {
    private static final Scanner console = new Scanner(System.in);
    private static final BookingDAO bookingDao = BookingDAO.getInstance();
    
    public static void mainMenu(){
        int option = -1;
        
        while(option != 0){
            System.out.println("Choose your option:");
            System.out.println("0 - Return to the main menu");
            System.out.println("1 - Register a new booking");
            System.out.println("2 - Edit a booking");
            System.out.println("3 - Check info from a booking");
            System.out.println("4 - List all bookings of a estate");
            System.out.println("5 - Remove a booking");
            option = console.nextInt();
            console.nextLine();
                   
            switch(option){
                case 0:
                    System.out.println(" ");
                    break;
                case 1:
                    register();
                    break;
                case 2:
                    edit();
                    break;
                case 3:
                    showUnique();
                    break;
                case 4:
                    list();
                    break;
                case 5:
                    delete();
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 0 and 5");
            }
        }
    }
    
    public static void register(){
        
        Person user = PersonDAO.getInstance().readById(0);
       
        System.out.println("Write the tenant name:");
        String tenantName = console.nextLine();
        
        PropertyDAO propertyDAO = PropertyDAO.getInstance();
        propertyDAO.readAll().values().forEach(p -> System.out.println(p));
        
        System.out.println("Choose the property id of this booking:");
        int chosenPropertyNum = console.nextInt();
        console.nextLine();
        Property p1 = propertyDAO.readById(chosenPropertyNum);
        
        System.out.println("Choose the check-in date (dd/mm/yyyy): ");
        console.nextLine();
        String checkIn = console.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate checkInDate = LocalDate.parse(checkIn, formatter);
        
        
        System.out.println("Choose the check-out date (dd/mm/yyyy): ");
        String checkOut = console.nextLine();
        LocalDate checkOutDate = LocalDate.parse(checkOut, formatter);
        
        System.out.println("Choose the price:");
        double totalPrice = console.nextDouble();
        console.nextLine();
        
        try {
            BookingController.register(user, tenantName, p1, checkInDate, checkOutDate, totalPrice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void edit() {
        
        bookingDao.readAll().values().forEach(b -> System.out.println(b));
        
        console.nextLine();
        System.out.println("Select the booking you want to edit: ");
        int chosenBooking = console.nextInt();
        console.nextLine();
        Booking booking = bookingDao.readById(chosenBooking);
        
        System.out.println("Write the new tenant name: ");
        String tenantName = console.nextLine();
        booking.setTenantName(tenantName);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Choose the new check-in date: ");
        String checkIn = console.nextLine();
        LocalDate checkInDate = LocalDate.parse(checkIn, formatter);
        booking.setCheckIn(checkInDate);
        
        System.out.println("Choose the new check-out date: ");
        String checkOut = console.nextLine();
        LocalDate checkOutDate = LocalDate.parse(checkOut, formatter);
        booking.setCheckOut(checkOutDate);
        
        System.out.println("Choose the new price:");
        double totalPrice = console.nextDouble();
        console.nextLine();
        booking.setTotalPrice(totalPrice);
        
        try {
            BookingController.edit(booking);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void showUnique() {
        System.out.println("Enter the booking ID: ");
        int bookingId = console.nextInt();
        console.nextLine();

        Booking booking = bookingDao.readById(bookingId);
        try {
            BookingController.showUnique(booking);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static void list(){
        System.out.println("Enter the property ID:");
        int propertyId = console.nextInt();
        console.nextLine();
        
        System.out.println("Here is the list of bookings related to this property:");
        BookingDAO.getInstance().getBookingData().values().forEach(booking -> {
            if(booking.getProperty().getId() == propertyId) {
                System.out.println(booking);   
            }
        });
    }
    
    public static void delete() {
        System.out.println("Enter the booking ID: ");
        int bookingId = console.nextInt();
        console.nextLine();
        
        try {
            BookingController.delete(bookingId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
