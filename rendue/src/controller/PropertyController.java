/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.DAO.PersonDAO;
import model.DAO.PropertyDAO;
import model.Person;
import model.Property;
import model.PropertyType;

/**
 *
 * @author 2024020129
 */
public class PropertyController {
    
    public static void register(String name, String address, PropertyType type){
        Person u1 = PersonDAO.getInstance().readById(0);
        
        Property t = new Property(u1, name, address, type);
        
        PropertyDAO.getInstance().create(t);
    }
    
    public static boolean edit(Property property) throws IllegalArgumentException {
        
        if(property.getBathroomAmount() < 1) throw new IllegalArgumentException("This property needs at least one bathroom");
        if(property.getRoomAmount() < 1) throw new IllegalArgumentException("This property needs at least one room");
        
        property.setUser(PersonDAO.getInstance().readById(0));
        
        boolean isUpdated = PropertyDAO.getInstance().update(property);
        
        if (isUpdated == false) {
            throw new IllegalArgumentException("Error updating property");
        }
        return true;
    }
    
    public static Property showUnique(Property property) throws IllegalArgumentException {
        Property p = PropertyDAO.getInstance().readById(property.getId());
        if (p == null) {
            throw new IllegalArgumentException("Property not found");
        }
        return p;
    }
    
    public static boolean delete(int id) throws IllegalArgumentException {
        Property property = PropertyDAO.getInstance().readById(id);
        
        boolean isDeleted = PropertyDAO.getInstance().delete(property);
        
        if (isDeleted == false) {
            throw new IllegalArgumentException("Error deleting property");
        }
        return true;
    }
    
}
