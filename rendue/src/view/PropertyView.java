/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.PropertyController;
import java.util.Scanner;
import model.DAO.PropertyDAO;
import model.Property;
import model.PropertyType;

/**
 *
 * @author vitor
 */
public class PropertyView {
    
    private static final Scanner console = new Scanner(System.in);
    private static final PropertyDAO propertyDAO = PropertyDAO.getInstance();
    
    public static void mainMenu(){
        int option = -1;
        
        while(option != 0){
            System.out.println("Choose your option:");
            System.out.println("0 - Return to the main menu");
            System.out.println("1 - Register a new estate");
            System.out.println("2 - Edit a estate");
            System.out.println("3 - Check info from a estate");
            System.out.println("4 - List all estates that you have");
            System.out.println("5 - Remove a estate");
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
    
    private static void register(){
        System.out.println("In order to register a new estate, please fill out the following form:");
        
        System.out.println("Name:");
        String name = console.nextLine();
        
        System.out.println("Address (include street, number, and neighborhood):");
        String address = console.nextLine();
        
        //the user is added inside the controller
        
        PropertyType chosenType = chooseType();
        
        PropertyController.register(name, address, chosenType);
        
    }
    
    private static void edit(){
        list();
        System.out.println("Choose the estate based on the ID: ");
        
        int id = console.nextInt();
        console.nextLine();
        
        System.out.println("Enter the name of this property:");
        String name = console.nextLine();
        
        System.out.println("Enter the address (include street, number, and neighborhood):");
        String address = console.nextLine();
        
        //the user is added inside the controller
        
        System.out.println("Enter the room amount:");
        int roomAmount = console.nextInt();
        console.nextLine();
        
        System.out.println("Enter the bathroom amount:");
        int bathroomAmount = console.nextInt();
        console.nextLine();
        
        PropertyType chosenType = chooseType();
        
        Property property = new Property(null, name, address, chosenType);
        property.setId(id);
        property.setRoomAmount(roomAmount);
        property.setBathroomAmount(bathroomAmount);
        
        try {
            PropertyController.edit(property);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void list(){
        propertyDAO.readAll().values().forEach(p -> System.out.println((Property) p));
    }
    
    private static void showUnique(){
        System.out.println("Enter the property ID: ");
        int propertyId = console.nextInt();
        
        Property property = propertyDAO.readById(propertyId);
        
        try {
            PropertyController.showUnique(property);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private static void delete(){
        System.out.println("Enter the property ID:");
        int propertyId = console.nextInt();
        
        try {
            PropertyController.delete(propertyId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static PropertyType chooseType(){
        System.out.println("Choose the type between these options:");
        System.out.println("1 - House");
        System.out.println("2 - Apartment");
        System.out.println("3 - Farm house");
        System.out.println("4 - Bed and breakfast");
        
        int chosenTypeNum = console.nextInt();
        console.nextLine();
        while (chosenTypeNum < 1 || chosenTypeNum > 4) {
            System.out.println("Choose between 1 and 4, please");
            chosenTypeNum = console.nextInt();
            console.nextLine();
        }
        
        return PropertyType.values()[chosenTypeNum - 1];
    }
    
}
