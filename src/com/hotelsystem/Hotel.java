package com.hotelsystem;
import java.util.ArrayList;
import java.util.Iterator;
public class Hotel {
    private String hotelName;
    private String customerType;
    private int date;
    private String weekendDay;
    private int totalCost;
    public Hotel(){
    }
    public Hotel(String hotelName, String customerType, int date, int totalCost) {
        this.hotelName = hotelName;
        this.customerType = customerType;
        this.date = date;
        this.totalCost = totalCost;
    }
    public String getHotelName() {
        return hotelName;
    }
    public String getCustomerType() {
        return customerType;
    }
    public int getDate() {
        return date;
    }
    public String getWeekendDay() {
        return weekendDay;
    }
    public int getTotalCost() {
        return totalCost;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", customerType='" + customerType + '\'' +
                ", date=" + date +
                ", weekendDay='" + weekendDay + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}
