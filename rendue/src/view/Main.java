/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.PersonController;
import java.time.LocalDate;
import java.util.Scanner;
import model.Booking;
import model.DAO.BookingDAO;
import model.DAO.PersonDAO;
import model.DAO.PropertyDAO;
import model.Person;
import model.Property;
import model.PropertyType;
import utils.MetaInfo;

/**
 *
 * @author 08220332
 */
public class Main {
    
    private static final Scanner console = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        MetaInfo.bookingCount = 0;
        MetaInfo.propertyCount = 0;
        MetaInfo.userCount = 0;
        
        header();
        
        registerUser();
        
        populateData();
        
        mainMenu();
        
        System.out.println("*--- Thank you for trusting RENDUE! ---*");

    }
    
    private static void mainMenu(){
        int option = -1;

        while(option != 0){
            System.out.println("Choose your option:");
            System.out.println("0 - Finish the program");
            System.out.println("1 - Deal with user data");
            System.out.println("2 - Deal with property data");
            System.out.println("3 - Deal with booking data");
            option = console.nextInt();
            console.nextLine();
            
            switch(option){
                case 0:
                    System.out.println(" ");
                    break;
                case 1:
                    PersonView.mainMenu();
                    break;
                case 2:
                    PropertyView.mainMenu();
                    break;
                case 3:
                    BookingView.mainMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 0 and 3");
            }
        }
    }
    
    private static void registerUser(){
        System.out.println("In order to use our system, you need to fill out your info:");
        
        System.out.println("Write your cpf, just the numbers");
        String cpf = console.nextLine();
        
        System.out.println("Now, write your first name");
        String name = console.nextLine();
        
        System.out.println("Now your last name");
        String lastName = console.nextLine();
        
        System.out.println("Lastly, your personal or professional email, please");
        String email = console.nextLine();
        
        Person user = new Person(cpf, name, lastName, email);
        
        PersonController.register(user);
    }
    
    private static void header(){
        System.out.println("*--- RENDUE APP ---*");
        System.out.println("Start being your own real estate now!");
        System.out.println("*---            ---*");
    }
    
    private static void populateData() {
        System.out.println("\n--- Populating sample data ---");
        Person owner = PersonDAO.getInstance().readById(0);

        Property p1 = new Property(owner, "Cozy Apartment", "Rua A, 100, Centro", PropertyType.APARTMENT);
        p1.setRoomAmount(2);
        p1.setBathroomAmount(1);
        PropertyDAO.getInstance().create(p1);

        Property p2 = new Property(owner, "Spacious House", "Avenida B, 250, Jardins", PropertyType.HOUSE);
        p2.setRoomAmount(4);
        p2.setBathroomAmount(3);
        PropertyDAO.getInstance().create(p2);

        Property p3 = new Property(owner, "Farm House Retreat", "Estrada C, 50, Zona Rural", PropertyType.FARM);
        p3.setRoomAmount(3);
        p3.setBathroomAmount(2);
        PropertyDAO.getInstance().create(p3);

        Property p4 = new Property(owner, "Urban Bedroom", "Rua D, 15, Vila", PropertyType.BEDROOM);
        p4.setRoomAmount(1);
        p4.setBathroomAmount(1);
        PropertyDAO.getInstance().create(p4);

        Property p5 = new Property(owner, "Modern Apartment", "Rua E, 300, Brooklin", PropertyType.APARTMENT);
        p5.setRoomAmount(3);
        p5.setBathroomAmount(2);
        PropertyDAO.getInstance().create(p5);

        Booking b1 = new Booking(owner, "Alice Smith", p1, LocalDate.of(2025, 8, 1), LocalDate.of(2025, 8, 7), 500.00);
        BookingDAO.getInstance().create(b1);

        Booking b2 = new Booking(owner, "Bob Johnson", p2, LocalDate.of(2025, 9, 10), LocalDate.of(2025, 9, 15), 1200.00);
        BookingDAO.getInstance().create(b2);

        Booking b3 = new Booking(owner, "Charlie Brown", p3, LocalDate.of(2025, 7, 20), LocalDate.of(2025, 7, 25), 800.00);
        BookingDAO.getInstance().create(b3);

        Booking b4 = new Booking(owner, "Diana Prince", p4, LocalDate.of(2025, 10, 5), LocalDate.of(2025, 10, 10), 300.00);
        BookingDAO.getInstance().create(b4);

        Booking b5 = new Booking(owner, "Eve Davis", p5, LocalDate.of(2025, 11, 1), LocalDate.of(2025, 11, 8), 950.00);
        BookingDAO.getInstance().create(b5);

        System.out.println("--- Sample data populated ---");
    }
}
