/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 08220332
 */
public enum PropertyType {
    HOUSE ("house"),
    APARTMENT ("apartment"),
    FARM ("farm house"),
    BEDROOM ("bed and breakfast");
    
    private PropertyType(String type){
        this.type = type;
    }
    
    private String type;
    
    public String getType(){
        return type;
    }
    
}
