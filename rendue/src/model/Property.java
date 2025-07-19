/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 08220332
 */
public class Property implements Serializable {
    private int id;
    private String name;
    private String address;
    private Person user;
    private int roomAmount;
    private int bathroomAmount;
    private PropertyType type;

    public Property(Person user, String name, String address, PropertyType type) {
        this.user = user;
        this.name = name;
        this.address = address;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

    public int getBathroomAmount() {
        return bathroomAmount;
    }

    public void setBathroomAmount(int bathroomAmount) {
        this.bathroomAmount = bathroomAmount;
    }

    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.address);
        hash = 83 * hash + Objects.hashCode(this.user);
        hash = 83 * hash + this.roomAmount;
        hash = 83 * hash + this.bathroomAmount;
        hash = 83 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Property other = (Property) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.roomAmount != other.roomAmount) {
            return false;
        }
        if (this.bathroomAmount != other.bathroomAmount) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return this.type == other.type;
    }

    @Override
    public String toString() {
        return "\nProperty #" + id +
           "\nDescription: " + name +
           "\nAddress: " + address +
           "\nOwner: " + this.getUser().getName() + " " + this.getUser().getLastName() +
           "\nRooms: " + roomAmount +
           "\nBathrooms: " + bathroomAmount +
           "\nType: " + type + "\n";
    }
    
}
