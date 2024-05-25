package FlightTicketBookingApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookTicket {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int passengerId=1;
        List<Flight> flights=new ArrayList<>();
        for(int i=0;i<2;i++ ){
            flights.add(new Flight());
        }
        while (true){
            System.out.println("1.Book Ticket");
            System.out.println("2. Cancel Ticket");
            int choice=sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter FlightId");
                    int flightId=sc.nextInt();
                    if(flightId>flights.size()){
                        System.out.println("Invalid Flight Number");
                        break;
                    }
                    Flight flight=null;
                    for(Flight f:flights){
                        if(f.flightId==flightId){
                            flight=f;
                            f.showSummary();
                        }
                    }
                    System.out.println("Enter No Tickets");
                    int noOfTic=sc.nextInt();
                    bookFlightTicket(flight,noOfTic,passengerId);
                    passengerId++;
                    break;
                case 2:
                    System.out.println("Enter Flight Id of The Ticket to cancel");

                    int flightIdToRemove=sc.nextInt();
                    Flight flightToRemove=null;
                    for(Flight f:flights){
                        if(f.flightId==flightIdToRemove){
                            flightToRemove=f;
                        }
                    }
                    if(flightToRemove==null) System.out.println(" Invalid FlightId");
                    System.out.println("Enter Passenger Id to Remove");
                    int idToRemove=sc.nextInt();
                    flightToRemove.cancelFlightTicket(idToRemove);
                    break;
            }
        }
    }



    private static void bookFlightTicket(Flight flight, int noOfTic, int passengerId) {
        String passengerDetails="";
        int costOfBooking=noOfTic* flight.price;
        passengerDetails="Flight Id " + flight.id + " passenger Id" +passengerId +
                " Tickets Booked " + noOfTic +" TOTAL PRICE :" +costOfBooking;
        flight.setDetails(passengerId,passengerDetails,noOfTic,costOfBooking);
        flight.bookingDetails();
        System.out.println("Ticket Booked Successfully");
    }
}
