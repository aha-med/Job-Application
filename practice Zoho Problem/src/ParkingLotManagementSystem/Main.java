package ParkingLotManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ParkingLot parkingLot=new ParkingLot("PTR 1234",5,5);
     while(true){
         System.out.println("\nWhat would you like to do?");
         System.out.println("1. Park a car");
         System.out.println("2. Remove a car");
         System.out.println("3. Available slots");
         System.out.println("4. Display Open Slots");
         System.out.println("5. Display Occupied Slots");
         System.out.println("6. Exit");
         System.out.println("Enter Your Choice: ");
         int choice=sc.nextInt();
         sc.nextLine();
         switch (choice){
             case 1:
                 System.out.println("Enter Your Vehicle Types");
                 String typeOfVehicle =sc.nextLine();
                 System.out.println("Enter Your Vehicle Reg No");
                 String regNo=sc.nextLine();
                 System.out.println("Enter Your Vehicle Color");
                 String color=sc.nextLine();
                 parkingLot.parkVehicle(typeOfVehicle,regNo,color);
                 break;

             case 2:
                 System.out.println("Enter your Ticket Number");
                 String ticketNo=sc.nextLine();
                 parkingLot.unPark(ticketNo);
                 break;

             case 3:
                 System.out.println("Enter your Vehicle Type");
                 String vehicleType=sc.nextLine();
                 int count=parkingLot.getNoOfOpenSlots(vehicleType);
                 System.out.println(count);
                 break;

             case 4:
                 System.out.println("Enter your Vehicle Type");
                 String vehicleTypeForAvailablity=sc.nextLine();
                 parkingLot.displayOpenSlots(vehicleTypeForAvailablity);
                 break;

             case 5:
                 System.out.println("Enter your Vehicle Type");
                 String occupiedVehicleType=sc.nextLine();
                 parkingLot.displayOccupiedSlots(occupiedVehicleType);
                 break;
             case 6:
                 System.exit(0);

         }
     }
    }
}
