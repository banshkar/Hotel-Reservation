package com.hotelsystem;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("...............................WELCOME TO  HOTEL RESERVATION SYSTEM .......................");
        System.out.println();
        Hotel check =new Hotel();
        Hotel hotel_1 =new Hotel("LakeWood","Regular",30,220);
        Hotel hotel_2 =new Hotel("RidgeWood","Reward", 15, 100);
        Hotel hotel_3 =new Hotel("Karma","Regular", 20 ,800);
        Hotel hotel_4 =new Hotel("HanShRaj","Reward", 30,  120);
        Hotel hotel_5 =new Hotel("DBCity","Reward", 25 ,1500);
        Hotel hotel_6 =new Hotel("Golden","Regular", 20 ,220);
        Hotel hotel_7 =new Hotel("Milan","Reward", 10, 80);
        Hotel hotel_9 =new Hotel("Vmart","Regular", 15, 6000);
        Hotel hotel_10 =new Hotel("GoldenCity","Regular", 25,150);
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
        System.out.println("...................display hotels...............");
        System.out.println(hotels);
    }
}
