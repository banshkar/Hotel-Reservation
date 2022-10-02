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
    public  int getDate(String date){
        String newDate ="";
        if(date.charAt(0)=='0'){
            char character =date.charAt(1);
            newDate =newDate+"0"+character;
        }
        else {
            char firstIndex =date.charAt(0);
            char secondIndex =date.charAt(1);
            newDate =newDate+firstIndex+secondIndex;
        }
        int day =Integer.parseInt(newDate);
        return day;
    }
    public void checkAvailable(ArrayList<Hotel>arrayList,String customerType,String date_1,String date_2) {
        boolean found =false;
        Iterator<Hotel> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Hotel hotel = iterator.next();
            if (hotel.date >= getDate(date_2) && hotel.date <= getDate(date_1) && hotel.customerType.equals(customerType)) {
                System.out.println("Hotel Name : "+hotel.hotelName+ " , "+"Rate of hotel per day ,$"+hotel.totalCost +" for "+hotel.customerType);
                found = true;
            }
        }
        if(!found){
            System.out.println("...................This date not available any hotel............. ");
        }
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
