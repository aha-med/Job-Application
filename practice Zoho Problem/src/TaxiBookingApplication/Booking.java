package TaxiBookingApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Booking {
    private static List<Taxi> createTaxi(int noOfTaxi) {
        List<Taxi> taxis=new ArrayList<>();
        for(int i=0;i<noOfTaxi;i++){
            taxis.add(new Taxi());
        }
        return taxis;
    }
    private static List<Taxi> getFreeTaxi(List<Taxi> taxis, int pickupTime,
                                          char pickupPoint) {
        List<Taxi> freeTaxis = new ArrayList<Taxi>();
        for(Taxi t : taxis)
        {
            //taxi should be free
            //taxi should have enough time to reach customer before pickuptime
            if(t.freeTime <= pickupTime && (Math.abs((t.currentSpot - '0') -
                    (pickupPoint - '0')) <= pickupTime - t.freeTime))
                freeTaxis.add(t);

        }
        return freeTaxis;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of Taxi");
        int noOfTaxi=sc.nextInt();
        List<Taxi> taxi=createTaxi(noOfTaxi);
        int id=1;
        while(true){
            System.out.println("0 - > Book Taxi");
            System.out.println("1 - > Print Taxi details");
            int choice=sc.nextInt();
            switch (choice){
                case 0:
                    int customerID = id;
                    System.out.println("Enter Pickup point");
                    char pickupPoint = sc.next().charAt(0);
                    System.out.println("Enter Drop point");
                    char dropPoint = sc.next().charAt(0);
                    System.out.println("Enter Pickup time");
                    int pickupTime = sc.nextInt();
                    if(pickupPoint<'A' || dropPoint<'A' || pickupPoint>'F' || dropPoint>'F'){
                        System.out.println("Invalid Pickup or Drop Point");
                    }
                    List<Taxi> freeTaxis=getFreeTaxi(taxi,pickupTime,pickupPoint);
                    if(freeTaxis.isEmpty())
                    {
                        System.out.println("No Taxi can be alloted. Exitting");
                        System.exit(0);
                    }
                    Collections.sort(freeTaxis,(a, b)->a.totalEarning - b.totalEarning);
                    bookTaxi(id,pickupPoint,dropPoint,pickupTime,freeTaxis);
                    id++;
                    break;
                case 1:
                    //two functions to print details
                    for(Taxi t : taxi)
                        t.printDetails();
                    break;

            }
        }
    }

    public static void bookTaxi(int customerID,char pickupPoint,char dropPoint,int pickupTime,List<Taxi> freeTaxis)
    {
        // to find nearest
        int min = 999;

        //distance between pickup and drop
        int distanceBetweenpickUpandDrop = 0;

        //this trip earning
        int earning = 0;

        //when taxi will be free next
        int nextfreeTime = 0;

        //where taxi is after trip is over
        char nextSpot = 'Z';

        //booked taxi
        Taxi bookedTaxi = null;

        //all details of current trip as string
        String tripDetail = "";

        for(Taxi t : freeTaxis)
        {
            int distanceBetweenCustomerAndTaxi = Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) * 15;
            if(distanceBetweenCustomerAndTaxi < min)
            {
                bookedTaxi = t;
                //distance between pickup and drop = (drop - pickup) * 15KM
                distanceBetweenpickUpandDrop = Math.abs((dropPoint - '0') - (pickupPoint - '0')) * 15;
                //trip earning = 100 + (distanceBetweenpickUpandDrop-5) * 10
                earning = (distanceBetweenpickUpandDrop-5) * 10 + 100;

                //drop time calculation
                int dropTime  = pickupTime + distanceBetweenpickUpandDrop/15;

                //when taxi will be free next
                nextfreeTime = dropTime;

                //taxi will be at drop point after trip
                nextSpot = dropPoint;

                // creating trip detail
                tripDetail = customerID + "               " + customerID + "          " + pickupPoint +  "      " + dropPoint + "       " + pickupTime + "          " +dropTime + "           " + earning;
                min = distanceBetweenCustomerAndTaxi;
            }

        }

        //setting corresponding details to allotted taxi
        bookedTaxi.setDetails(true,nextSpot,nextfreeTime,bookedTaxi.totalEarning + earning,tripDetail);
        //BOOKED SUCCESSFULLY
        System.out.println("Taxi " + bookedTaxi.id + " booked");

    }

    }



