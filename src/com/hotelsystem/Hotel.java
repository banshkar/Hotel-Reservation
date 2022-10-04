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
    public int getRating() {
        return rating;
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
    public int findMiniCost(ArrayList<Integer>arrayList){
        List<Integer>sortedList =arrayList.stream().sorted().collect(Collectors.toList());
        int miniCost =sortedList.get(0);
        return miniCost;
    }
    public int findMaxCost(ArrayList<Integer>arrayList){
        List<Integer>sortedList =arrayList.stream().sorted().collect(Collectors.toList());
        int maxCost =sortedList.get(sortedList.size()-1);
        return maxCost;
    }
    public int findMiniRating(ArrayList<Integer>arrayList){
        List<Integer>sortedList =arrayList.stream().sorted().collect(Collectors.toList());
        int maxRating =sortedList.get(0);
        return  maxRating;
    }
    public int findMaxRating(ArrayList<Integer>arrayList){
        List<Integer>sortedList =arrayList.stream().sorted().collect(Collectors.toList());
        int maxRating=sortedList.get(sortedList.size()-1);
        return  maxRating;
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
                 if(hotel.getTotalCost(hotel.weekend,hotel.getWeekdays())==findMiniCost(costList)){
                     System.out.println("Hotel Name: "+hotel.getHotelName()+"  $"+findMiniCost(costList));
                 }
              }
        }
        else {
            System.out.println("No Available");
        }
    }
    public void findCheapestHotelWithRating(ArrayList<Hotel>arrayList ,String date_1,String date_2) {
        boolean found =false;
        ArrayList<Integer>ratingList=new ArrayList<>();
        ArrayList<Integer>costList=new ArrayList<>();
        Iterator<Hotel> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Hotel hotel = iterator.next();
            if (hotel.date >= getDate(date_1) && hotel.date <= getDate(date_2)){
                int ratings =hotel.rating;
                int cost =getTotalCost(hotel.getWeekend(),hotel.getWeekdays());
                costList.add(cost);
                ratingList.add(ratings);
                found=true;
            }
        }
        if (found){
            iterator =arrayList.iterator();
            while (iterator.hasNext()){
                Hotel hotel =iterator.next();
                if(hotel.getTotalCost(hotel.weekend,hotel.getWeekdays())==findMaxCost(costList)){
                    System.out.println("Hotel Name: "+hotel.getHotelName()+" +, $"+hotel.getTotalCost(hotel.getWeekend(),hotel.getWeekdays()));
                }
            }
        }
        else {
            System.out.println("No Available");
        }
    }
    public void findBestHotel(ArrayList<Hotel>arrayList ,String date_1,String date_2) {
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
                if(hotel.getTotalCost(hotel.weekend,hotel.getWeekdays())==findMaxCost(costList)){
                    System.out.println("Hotel Name: "+hotel.getHotelName()+"  $"+findMiniCost(costList));
                }
            }
        }
        else {
            System.out.println("No Available");
        }
    }
    public void findBestHotelForRewardsCustomer(ArrayList<Hotel>arrayList ,String date_1,String date_2,String customerTyre) {
        boolean found =false;
        ArrayList<Integer>costList=new ArrayList<>();
        ArrayList<Integer>ratingList=new ArrayList<>();
        Iterator<Hotel> iterator = arrayList.iterator();
        try {
            while (iterator.hasNext()) {
                Hotel hotel = iterator.next();
                if (hotel.customerType.equals(customerTyre) && hotel.date >= getDate(date_1) && hotel.date <= getDate(date_2)) {
                    int cost = getTotalCost(hotel.getWeekend(), hotel.getWeekdays());
                    costList.add(cost);
                    ratingList.add(hotel.rating);
                    found = true;
                }
            }
            if (found) {
                iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    Hotel hotel = iterator.next();
                    if (hotel.customerType.equals(customerTyre) && hotel.getTotalCost(hotel.weekend, hotel.getWeekdays()) == findMaxCost(costList) && hotel.rating == findMaxRating(ratingList)) {
                        System.out.println("Hotel Name: " + hotel.getHotelName() + "  $" + findMaxCost(costList) + ",for " + hotel.customerType + " customer");
                    }
                }

            } else {
                System.out.println(" No Available  ");
            }
        }catch (Exception e){
            System.out.println(e);
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
