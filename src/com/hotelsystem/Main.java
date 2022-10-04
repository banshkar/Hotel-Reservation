package com.hotelsystem;
import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("...............................WELCOME TO  HOTEL RESERVATION SYSTEM .......................");
        System.out.println();
        Hotel hotelSystem =new Hotel();
        Hotel hotel_1 =new Hotel("LakeWood","Regular",30,180,150,4);
        Hotel hotel_2 =new Hotel("RidgeWood","Reward", 15, 80,90,3);
        Hotel hotel_12 =new Hotel("RidgeWood_1","Reward", 14, 80,90,3);
        Hotel hotel_3 =new Hotel("Karma","Regular", 14 ,600,700,5);
        Hotel hotel_4 =new Hotel("HanShRaj","Reward", 30,  60,80,4);
        Hotel hotel_5 =new Hotel("DBCity","Reward", 25 ,80,30,3);
        Hotel hotel_6 =new Hotel("Golden","Regular", 20 ,220,210,3);
        Hotel hotel_7 =new Hotel("Milan","Reward", 10, 80,120,5);
        Hotel hotel_9 =new Hotel("Vmart","Regular", 15, 90,80,4);
        Hotel hotel_11 =new Hotel("HanshRaj","Reward", 13, 90,80,5);
        Hotel hotel_10 =new Hotel("GoldenCity","Regular", 25,150,130,5);
        ArrayList<Hotel>hotels =new ArrayList<>();
        hotels.add(hotel_1);
        hotels.add(hotel_2);
        hotels.add(hotel_3);
        hotels.add(hotel_4);
        hotels.add(hotel_5);
        hotels.add(hotel_6);
        hotels.add(hotel_7);
        hotels.add(hotel_9);
        hotels.add(hotel_10);
        hotels.add(hotel_11);
        hotels.add(hotel_12);
        System.out.println("...................display hotels...............");
        int choice;
        Scanner sc =new Scanner(System.in);
        do{
            System.out.println(" 1. enter for check available");
            System.out.println(" 2. enter for all display");
            System.out.println(" 3. enter find cheapest hotel");
            System.out.println(" 4. enter find cheapest hotel base rating");
            System.out.println(" 5. enter find best hotel ");
            System.out.println(" 6. enter find cheapest hotel and best rating for rewards customer");
            System.out.println(" 7. enter find cheapest hotel and best rating for rewards customer");
            System.out.println(" 8. enter find cheapest hotel and best rating for regular customer");
            System.out.println(" 0. enter for exit");
            choice =sc.nextInt();
            switch (choice){
                case 1:
                    String line =sc.nextLine();
                    System.out.println("Enter customer type");
                    String customerType =sc.nextLine();
                    System.out.println("Enter date_1 format(01sep2022)");
                    String date_1 =sc.nextLine();
                    System.out.println("Enter date_2 format(01sep2022)");
                    String date_2 =sc.nextLine();
                    hotelSystem.checkAvailable(hotels,customerType,date_1,date_2);
                   break;
                case 2:
                    Iterator<Hotel>iterator = hotels.iterator();
                    while (iterator.hasNext()){
                        Hotel hotel =iterator.next();
                        System.out.println(hotel);
                    }
                    break;
                case 3:
                    hotelSystem.findCheapestHotel(hotels,"14sep2022","16sep2022");
                    break;
                case 4:
                    hotelSystem.findCheapestHotelWithRating(hotels,"14sep2022","16sep2022");
                    break;
                case 5:
                    hotelSystem.findBestHotel(hotels,"14sep2022","16sep2022");
                    break;
                case 6:
                    hotelSystem.findBestHotelForRewardsCustomer(hotels,"12sep2022","16sep2022","Reward");
                    break;
                case 7:
                    Pattern pattern =Pattern.compile("^[0-9]{2}+[a-zA-Z]+?(2022)+$");
                    try {
                        line = sc.nextLine();
                        System.out.println("Enter first date:");
                        String firstDate = sc.nextLine();
                        System.out.println("Enter second date:");
                        String secondDate = sc.nextLine();
                        Matcher matcher = pattern.matcher(firstDate);
                        Matcher matcher1 = pattern.matcher(secondDate);
                        if (matcher1.matches() && matcher.matches()) {
                            hotelSystem.findBestHotelForRewardsCustomer(hotels, firstDate, secondDate, "Reward");
                        } else {
                            System.out.println("Enter valid input");
                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 8:
                     pattern =Pattern.compile("^[0-9]{2}+[a-zA-Z]+?(2022)+$");
                    try {
                        line = sc.nextLine();
                        System.out.println("Enter first date:");
                        String firstDate = sc.nextLine();
                        System.out.println("Enter second date:");
                        String secondDate = sc.nextLine();
                        Matcher matcher = pattern.matcher(firstDate);
                        Matcher matcher1 = pattern.matcher(secondDate);
                        if (matcher1.matches() && matcher.matches()) {
                            hotelSystem.findBestHotelForRewardsCustomer(hotels, firstDate, secondDate, "Regular");
                        } else {
                            System.out.println("Enter valid input");
                        }
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
            }
        }while (choice!=0);
    }
}
