/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DAO.PersonDAO;
import model.Person;

/**
 *
 * @author karen
 */
public class PersonController {

    public static void register(Person user) throws IllegalArgumentException {
        boolean isValid = isCpfValid(user.getCPF());
        
        if(!isValid) throw new IllegalArgumentException("User has invalid CPF");
        
        PersonDAO.getInstance().create(user);
    }
    
    public static void edit(Person user) throws IllegalArgumentException{
        boolean isValid = isCpfValid(user.getCPF());
        
        if(!isValid) throw new IllegalArgumentException("User has invalid CPF");
        
        PersonDAO.getInstance().update(user);
    }
    
    public static boolean isCpfValid(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        int firstVerifDigit = 0;
        int j = 10;
        for (int i = 0; i <= 8; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            firstVerifDigit += digit * j;
            j--;
        }

        int remainder = firstVerifDigit % 11;
        if (remainder < 2) {
            firstVerifDigit = 0;
        } else {
            firstVerifDigit = 11 - remainder;
        }

        int secondVerifDigit = 0;
        j = 11;
        for (int i = 0; i <= 9; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            secondVerifDigit += digit * j;
            j--;
        }

        remainder = secondVerifDigit % 11;
        if (remainder <= 2) {
            secondVerifDigit = 0;
        } else {
            secondVerifDigit = 11 - remainder;
        }

        if (Character.getNumericValue(cpf.charAt(9)) == firstVerifDigit &&
            Character.getNumericValue(cpf.charAt(10)) == secondVerifDigit) {

            for (int i = 0; i < cpf.length() - 1; i++) {
                if (cpf.charAt(i) != cpf.charAt(i + 1)) {
                    return true;
                }
            }
            return false;
        }

        return false;
    }
    
}
