package FlightTicketBookingApplication;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    static int id=0;
    int flightId;
    int ticket=50;
    int price=5000;
    List<String> passengerDetails;
    List<Integer> passengerCost;
    List<Integer> bookedTicket;
    List<Integer> noOfTicketBooked;
    
    Flight(){
        id=id+1;
        flightId=id;
        passengerCost=new ArrayList<>();
        passengerDetails=new ArrayList<>();
        bookedTicket=new ArrayList<>();
        noOfTicketBooked=new ArrayList<>();
    }

    void setDetails(int passengerId,String passengerDetail,int noOfTickets,
                    int costOfBooking) {
        passengerCost.add(costOfBooking);
        passengerDetails.add(passengerDetail);
        bookedTicket.add(passengerId);
        noOfTicketBooked.add(noOfTickets);
        price+=noOfTickets*200;
        ticket-=noOfTickets;
    }

    public void bookingDetails() {
        for (String detail:passengerDetails){
            System.out.println(detail);
        }
    }
    public  void showSummary(){
        System.out.println("Flight id "+ flightId +" Current Ticket Price "+ price);
    }
     void cancelFlightTicket(int passengerIdtoRemove) {
        int indexofPass=bookedTicket.indexOf(passengerIdtoRemove);
        if(indexofPass==-1){
            System.out.println("Invalid passenger Id");
            return;
        }
        int passBookedTickets=noOfTicketBooked.get(indexofPass);
        price-=200*passBookedTickets;
        passengerDetails.remove(indexofPass);
        int amountTORefund=passengerCost.get(indexofPass);
         System.out.println("Amount to Refund : "+ amountTORefund);
         System.out.println("Ticket cancelled Successfully");
        bookedTicket.remove(indexofPass);
        noOfTicketBooked.remove(indexofPass);
        passengerCost.remove(indexofPass);
    }
}
