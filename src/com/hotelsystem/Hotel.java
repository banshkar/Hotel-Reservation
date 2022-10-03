package com.hotelsystem;
import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
public class Hotel {
    private String hotelName;
    private String customerType;
    private int date;
    private int weekdays;
    private int  weekend;
    private int rating;
    private int totalCost;
    public Hotel(){
    }
    public Hotel(String hotelName, String customerType, int date,int weekdays, int weekend,int rating){
        this.hotelName = hotelName;
        this.customerType = customerType;
        this.date = date;
        this.weekdays=weekdays;
        this.weekend=weekend;
        this.rating =rating;
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
    public int getWeekdays() {
        return weekdays;
    }
    public int getTotalCost(int weekend,int weekdays) {
         totalCost =weekdays+weekend;
        return totalCost;
    }
    public int getWeekend() {
        return weekend;
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
    public int findMniCost(ArrayList<Integer>arrayList){
        List<Integer>sortedList =arrayList.stream().sorted().collect(Collectors.toList());
        int miniCost =sortedList.get(0);
        return miniCost;
    }
    public void checkAvailable(ArrayList<Hotel>arrayList,String customerType,String date_1,String date_2) {
        boolean found =false;
        Iterator<Hotel> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Hotel hotel = iterator.next();
            if (hotel.date >= getDate(date_1) && hotel.date <= getDate(date_2) && hotel.customerType.equals(customerType)) {
                System.out.println("Hotel Name : "+hotel.hotelName+ " , "+"Rate of hotel per day ,$"+hotel.totalCost +" for "+hotel.customerType);
                found = true;
            }
        }
        if(!found){
            System.out.println("...................This date not available any hotel............. ");
        }
    }
    public void findCheapestHotel(ArrayList<Hotel>arrayList ,String date_1,String date_2) {
        boolean found =false;
        ArrayList<Integer>costList=new ArrayList<>();
        Iterator<Hotel> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Hotel hotel = iterator.next();
            if (hotel.date >= getDate(date_1) && hotel.date <= getDate(date_2)){
                int cost =getTotalCost(hotel.getWeekend(),hotel.getWeekdays());
                costList.add(cost);
                found=true;
            }
        }
        if (found){
              iterator =arrayList.iterator();
              while (iterator.hasNext()){
                  Hotel hotel =iterator.next();
                 if(hotel.getTotalCost(hotel.weekend,hotel.getWeekdays())==findMniCost(costList)){
                     System.out.println("Hotel Name "+hotel.getHotelName()+"  $"+findMniCost(costList));
                 }
              }
        }
        else {
            System.out.println("not ");
        }
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", customerType='" + customerType + '\'' +
                ", date=" + date +
                ", weekdays=" + weekdays +
                ", weekend=" + weekend +
                ", rating=" + rating +
                ", totalCost=" + totalCost +
                '}';
    }
}
