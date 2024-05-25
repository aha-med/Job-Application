package RailwayReservation;

import java.util.*;

public class TicketBooking {
    static HashMap<Integer, Passenger> passengers = new HashMap<>();
    static int avaiLowBerth = 21;
    static int avaiMidBerth = 21;
    static int availUppBerth = 21;
    static int avilRac = 18;
    static int avaiWaitingList = 10;
    static List<Integer> lowerBerPo = new ArrayList<>(Arrays.asList
            (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21));
    static List<Integer> upperBerthPos = new ArrayList<>(Arrays.asList
            (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21));
    static List<Integer> midBerthPos = new ArrayList<>(Arrays.asList
            (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21));
    static List<Integer> racPos = new ArrayList<>(Arrays.asList
            (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18));
    static List<Integer> waitingPos = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    static Queue<Integer> waitingListQue = new LinkedList<>();
    static Queue<Integer> racQueue = new LinkedList<>();
    static List<Integer> bookedTicket = new ArrayList<>();

    public static void addToRac(Passenger passenger, Integer racPosition, String rac) {
        avilRac--;
        racPos.remove(0);
        passenger.number = racPosition;
        passenger.alloted = rac;
        passengers.put(passenger.passengerId, passenger);
        racQueue.add(passenger.passengerId);
        System.out.println("----RAC Successfully-------");
    }

    public static void addToWaiting(Passenger passenger, Integer waitingNumber, String waiting) {
        avaiWaitingList--;
        passenger.number = waitingNumber;
        passenger.alloted = waiting;
        waitingPos.remove(0);
        waitingListQue.add(passenger.passengerId);
        passengers.put(passenger.passengerId, passenger);
        System.out.println("Added to Waiting List Successfully");
    }

    public static void cancelTicket(int passengerId) {
        Passenger passenger = passengers.get(passengerId);
        passengers.remove(passengerId);
        bookedTicket.remove(Integer.valueOf(passengerId));
        if (passenger.alloted.equals("L")) {
            avaiLowBerth++;
            lowerBerPo.add(passenger.number);
        }
        if (passenger.alloted.equals("M")) {
            avaiMidBerth++;
            midBerthPos.add(passenger.number);
        }
        if (passenger.alloted.equals("U")) {
            availUppBerth++;
            upperBerthPos.add(passenger.number);
        }
        if (!racQueue.isEmpty()) {
            int racPerson = racQueue.poll();
            Passenger passengerFromRac = passengers.get(racPerson);
            racPos.add(passengerFromRac.number);
            passengerFromRac.number=passenger.number;
            passengerFromRac.alloted=passenger.alloted;
            avilRac++;
            if(avaiWaitingList>0){
              int waitingPerson=  waitingListQue.poll();
              Passenger passengerFromWaiting=passengers.get(waitingPerson);
              avaiWaitingList++;
             waitingPos.add(passengerFromWaiting.number);
              passengerFromWaiting.number= racPos.get(0);
              racPos.remove(0);
              passengerFromWaiting.alloted="RAC";
              avilRac--;
              avaiWaitingList++;
            }
            Main.bookTicket(passengerFromRac);
        }
    }


    public void bookTicket(Integer ticketNumber, Passenger passenger, String berthPrefernce) {
        passenger.number = ticketNumber;
        passenger.alloted = berthPrefernce;
        passengers.put(passenger.passengerId, passenger);
        bookedTicket.add(passenger.passengerId);
        System.out.println("-----Booked Successfully------");
    }
    public void printAvailable()
    {
        System.out.println("Available Lower Berths "  + avaiLowBerth);
        System.out.println("Available Middle Berths "  + avaiMidBerth);
        System.out.println("Available Upper Berths "  + availUppBerth);
        System.out.println("Availabel RACs " + avilRac);
        System.out.println("Available Waiting List " + avaiWaitingList);
        System.out.println("--------------------------");
    }
    public void printPassengers()
    {
        if(passengers.size() == 0)
        {
            System.out.println("No details of passengers");
            return;
        }
        for(Passenger p : passengers.values())
        {
            System.out.println("PASSENGER ID " + p.passengerId );
            System.out.println(" Name " + p.name );
            System.out.println(" Age " + p.age );
            System.out.println(" Status " + p.number + p.alloted);
            System.out.println("--------------------------");
        }
    }

}
