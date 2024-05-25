package TaxiBookingApplication;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
   static int taxicount=0;
   int id=0;
    int freeTime;
    int totalEarning;
    char currentSpot;
    boolean booked;
    List<String> trips;

    public Taxi() {
        this.freeTime = 6;
        this.totalEarning =0 ;
        this.currentSpot = 'A';
        this.booked = false;
        taxicount++;
        this.id=taxicount;
        trips=new ArrayList<>();
    }

    public void setDetails(boolean booked, char nextStop,int freeTime,int totalEarning, String tripDetails) {
        this.freeTime=freeTime;
        this.totalEarning=totalEarning;
        this.booked=true;
        this.trips.add(tripDetails);
        this.currentSpot=nextStop;
    }
    public void printDetails()
    {
        System.out.println("Taxi - "+ this.id + " Total Earnings - " + this.totalEarning);
        System.out.println("TaxiID    BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
        for(String trip : trips)
        {
            System.out.println(id + "          " + trip);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }
}
