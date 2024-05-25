package RailwayReservation;

import java.util.Scanner;

public class Main {

    public static void bookTicket(Passenger passenger) {
        TicketBooking booking=new TicketBooking();
     if(passenger.berthPreference.equals("L") && TicketBooking.avaiLowBerth>0
       || passenger.berthPreference.equals("M") && TicketBooking.avaiMidBerth>0
     || passenger.berthPreference.equals("U") && TicketBooking.availUppBerth>0){
         if(passenger.berthPreference.equals("L")){
             System.out.println("Lower Berth Given");
             TicketBooking.avaiLowBerth--;
             booking.bookTicket(TicketBooking.lowerBerPo.get(0),passenger,"L");
             TicketBooking.lowerBerPo.remove(0);
         }
        else if(passenger.berthPreference.equals("M")){
             System.out.println("Middle Berth Given");
             TicketBooking.avaiLowBerth--;
             booking.bookTicket(TicketBooking.midBerthPos.get(0),passenger,"M");
             TicketBooking.midBerthPos.remove(0);
         }
        else if(passenger.berthPreference.equals("U")){
             System.out.println("Upper Berth Given");
             TicketBooking.avaiLowBerth--;
             booking.bookTicket(TicketBooking.upperBerthPos.get(0),passenger,"U");
             TicketBooking.upperBerthPos.remove(0);
         }

     }
     else if (TicketBooking.avaiLowBerth>0) {
         System.out.println("Lower Berth Given");
         TicketBooking.avaiLowBerth--;
         booking.bookTicket(TicketBooking.lowerBerPo.get(0),passenger,"L");
         TicketBooking.lowerBerPo.remove(0);
     }
     else if(TicketBooking.avaiMidBerth>0){
         System.out.println("Middle Berth Given");
         TicketBooking.avaiLowBerth--;
         booking.bookTicket(TicketBooking.lowerBerPo.get(0),passenger,"M");
         TicketBooking.midBerthPos.remove(0);
     }
     else if(TicketBooking.availUppBerth>0){
         System.out.println("Upper Berth Given");
         TicketBooking.avaiLowBerth--;
         booking.bookTicket(TicketBooking.lowerBerPo.get(0),passenger,"U");
         TicketBooking.upperBerthPos.remove(0);
     }
     else if (TicketBooking.avilRac>0) {
         System.out.println("Rac Available");
         TicketBooking.avilRac--;
         TicketBooking.addToRac(passenger,TicketBooking.racPos.get(0),"RAC");
     }
     else if(TicketBooking.avaiWaitingList>0){
         System.out.println(" Ticket Have Filled Waiting List");
         TicketBooking.avaiWaitingList--;
         TicketBooking.addToWaiting(passenger,TicketBooking.waitingPos.get(0),"WAITING");

     }


    }
    public static void main(String[] args) {
        TicketBooking booking=new TicketBooking();
        Scanner sc=new Scanner(System.in);
    while (true){
        System.out.println(" 1. Book Ticket \n" +
                " 2. Cancel Ticket \n" +
                " 3. Available Tickets \n " +
                "4. Booked Tickets \n " +
                "5. Exit");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                System.out.println("Enter the Passenger Details");
                System.out.println("Name");
                String name=sc.nextLine();
                System.out.println("Age");
                int age=sc.nextInt();
                sc.nextLine();
                System.out.println("---Preferred Birth---");
                String preference=sc.nextLine();
                Passenger passenger=new Passenger(name,age,preference);
                bookTicket(passenger);
                break;
            case 2:
                System.out.println("Enter Your Passenger Id");
                int passengerId=sc.nextInt();
                TicketBooking.cancelTicket(passengerId);
                break;
            case 3:
                booking.printAvailable();
                break;
            case 4:
                 booking.printPassengers();
                 break;
            case 5:
                System.exit(0);
        }
    }
    }


}
