package ParkingLotManagementSystem;

public class Slot {
    String typeOfVehicle;
    Vehicle vehicle;
    String ticketId;

    public Slot(String typeOfVehicle, Vehicle vehicle, String ticketId) {
        this.typeOfVehicle = typeOfVehicle;
        this.vehicle = vehicle;
        this.ticketId = ticketId;
    }
    public Slot(String typeOfVehicle){
        this.typeOfVehicle=typeOfVehicle;
    }
}
