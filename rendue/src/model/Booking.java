/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Vitor
 */
public class Booking implements Serializable {
    private int id;
    private Person user;
    private String tenantName;
    private Property property;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double totalPrice;

    public Booking(Person user, String tenantName, Property property, LocalDate checkIn, LocalDate checkOut, double totalPrice) {
        this.user = user;
        this.tenantName = tenantName;
        this.property = property;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.user);
        hash = 59 * hash + Objects.hashCode(this.tenantName);
        hash = 59 * hash + Objects.hashCode(this.property);
        hash = 59 * hash + Objects.hashCode(this.checkIn);
        hash = 59 * hash + Objects.hashCode(this.checkOut);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.totalPrice) ^ (Double.doubleToLongBits(this.totalPrice) >>> 32));
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
        final Booking other = (Booking) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalPrice) != Double.doubleToLongBits(other.totalPrice)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.tenantName, other.tenantName)) {
            return false;
        }
        if (!Objects.equals(this.property, other.property)) {
            return false;
        }
        if (!Objects.equals(this.checkIn, other.checkIn)) {
            return false;
        }
        return Objects.equals(this.checkOut, other.checkOut);
    }

    @Override
    public String toString() {
        return "\nBooking #" + id +
           "\nUser: " + user +
           "\nTenant: " + tenantName +
           "\nProperty: " + property +
           "\nCheck-in: " + checkIn +
           "\nCheck-out: " + checkOut +
           "\nTotal Price: $" + String.format("%.2f", totalPrice) + "\n";
    }
}
