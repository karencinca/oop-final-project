/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.Serializable;

/**
 *
 * @author 08220332
 */
public class MetaInfo implements Serializable{
    public static int bookingCount;
    public static int propertyCount;
    public static int userCount;

    public static void setBookingCount(int bookingCount) {
        MetaInfo.bookingCount = bookingCount;
    }

    public static void setPropertyCount(int propertyCount) {
        MetaInfo.propertyCount = propertyCount;
    }

    public static void setUserCount(int userCount) {
        MetaInfo.userCount = userCount;
    }
    
    
}