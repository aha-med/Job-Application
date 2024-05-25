package ParkingLotManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    List<List<Slot>> slots;

    public ParkingLot(String parkingLotId,int nFloor,int NoOfslotsPerFloor){
        this.parkingLotId=parkingLotId;
        slots = new ArrayList<>();
        for(int i=0;i<nFloor;i++){
            slots.add(new ArrayList<>());
           slots.get(i).add(new Slot("truck"));
            slots.get(i).add(new Slot("bike"));
            slots.get(i).add(new Slot("car"));
            for(int j=3;j<NoOfslotsPerFloor;j++){
                slots.get(i).add(new Slot("car"));
            }
        }
    }

    public String parkVehicle(String typeOfVehicle,String regNo, String color){
     Vehicle vehicle=new Vehicle(typeOfVehicle,regNo,color);
        for(int i=0; i<slots.size();i++){
            for(int j=0;j<slots.get(i).size(); j++){
                Slot slot = slots.get(i).get(j);
                if(slot.typeOfVehicle.equals(typeOfVehicle) && slot.vehicle == null) {
                    slot.vehicle=vehicle;
                    slot.ticketId=generateTicketId(i+1, j+1);
                    System.out.println(slot.ticketId);
                    return "Parked Successfully";
                }
            }
        }
        System.out.println("NO slot available for given type");
        return null;
    }

    private String generateTicketId(int flr, int slno){
        return "Parked Your Car Successfully !\n Your tickedId : " + parkingLotId + "_" + flr + "_" + slno;
    }
    public void unPark(String ticketId){
        String[] extract = ticketId.split("_");
        int flr_idx=Integer.parseInt(extract[1])-1;
        int slot_idx=Integer.parseInt(extract[2])-1;
        for(int i=0; i<slots.size();i++){
            for(int j=0;j<slots.get(i).size(); j++){
                if(i==flr_idx && j==slot_idx) {
                    Slot slot = slots.get(i).get(j);
                    slot.vehicle=null;
                    slot.ticketId=null;
                    System.out.println("Unparked vehicle");
                }
            }
        }
    }
    int getNoOfOpenSlots(String type){
        int count=0;
        for(List<Slot> floor: slots){
            for(Slot slot: floor){
                if(slot.vehicle == null && slot.typeOfVehicle.equals(type)) count++;
            }
        }

        return count;
    }
    void displayOpenSlots(String type){
        for(int i=0;i<slots.size();i++){
            for(int j=0;j<slots.get(i).size();j++){
                Slot slot=slots.get(i).get(j);
                if(slot.vehicle == null && slot.typeOfVehicle.equals(type))
                    System.out.println("Floor " + (i+1) + " slot " + (j+1));
            }
        }
    }
    void displayOccupiedSlots(String type){
        for(int i=0;i<slots.size();i++){
            for(int j=0;j<slots.get(i).size();j++){
                Slot slot=slots.get(i).get(j);
                if(slot.vehicle != null && slot.typeOfVehicle.equals(type))
                    System.out.println("Floor " + (i+1) + " slot " + (j+1));
            }
        }
    }
}
