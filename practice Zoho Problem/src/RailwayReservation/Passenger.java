package RailwayReservation;

public class Passenger
{
    static int id = 1;
    String name;
    int age;
    String berthPreference;// U or L or M
    int passengerId;// id of passenger created automatically
    String alloted;//alloted type (L,U,M,RAC,WL)
    int number;//seat number
    public Passenger(String name,int age,String berthPreference)
    {
        this.name = name;
        this.age = age;
        this.berthPreference = berthPreference;
        this.passengerId = id++;
        alloted = "";
        number = -1;
    }
}
