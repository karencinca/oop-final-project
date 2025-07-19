/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.util.HashMap;
import model.Property;
import utils.MetaInfo;

/**
 *
 * @author 08220332
 */
public class PropertyDAO implements DAO<Integer, Property> {
    
    private HashMap<Integer, Property> propertyData;
    private static PropertyDAO instance;
    
    private PropertyDAO(){
        propertyData = new HashMap();
    }
    
    public static PropertyDAO getInstance(){
        if(instance == null){
            instance = new PropertyDAO();
        }
        return instance;
    }

    @Override
    public void create(Property t) {
        t.setId(MetaInfo.propertyCount++);
        propertyData.put(t.getId(), t);
    }

    @Override
    public boolean read(Property t) {
         return propertyData.containsValue(t);
    }

    @Override
    public boolean delete(Property t) {
        if(read(t)){
            propertyData.remove(t.getId(), t);
            return true;
        } 
        return false;
    }

    @Override
    public HashMap<Integer, Property> readAll() {
        return propertyData;
    }

    @Override
    public Property readById(int id) {
        return propertyData.get(id);
    }
    
    public boolean update(Property t){
        if(propertyData.containsKey(t.getId())){
            propertyData.put(t.getId(), t);
            return true;
        }
        return false;
    }

    public HashMap<Integer, Property> getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(HashMap<Integer, Property> propertyData) {
        this.propertyData = propertyData;
    }
}
