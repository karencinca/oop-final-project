/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.PersonController;
import java.util.Scanner;
import model.DAO.PersonDAO;
import model.Person;

/**
 *
 * @author vitor
 */
public class PersonView {
    
    private static final Scanner console = new Scanner(System.in);
    
    public static void mainMenu(){
        int option = -1;
               
        while(option != 0){
            System.out.println("Choose your option:");
            System.out.println("0 - Return to the main menu");
            System.out.println("1 - Edit your info");
            option = console.nextInt();
            console.nextLine();
            
            switch(option){
                case 0:
                    System.out.println(" ");
                    break;
                case 1:
                    edit();
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 0 and 2");
            }
        }
    }
    
    private static void edit(){
        Person u1 = PersonDAO.getInstance().readById(0);
        System.out.println(u1);
        
        System.out.println("That's your user. Edit the info now: ");
        console.nextLine(); //clean buffer
        System.out.println("CPF: ");
        String cpf = console.nextLine();
        
        System.out.println("First name: ");
        String name = console.nextLine();
        
        System.out.println("Last name: ");
        String lastName = console.nextLine();
        
        System.out.println("Email: ");
        String email = console.nextLine();
        
        Person user = new Person(cpf, name, lastName, email);
        
        try {
            PersonController.edit(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
