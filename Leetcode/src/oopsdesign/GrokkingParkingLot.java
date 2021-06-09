package src.oopsdesign;

import java.util.HashMap;

public class GrokkingParkingLot {
}


enum VehicleType1 {
    CAR, TRUCK, ELECTRIC, VAN, MOTORBIKE
}

 enum ParkingSpotType {
    HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC
}

 enum AccountStatus1 {
    ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
}

 enum ParkingTicketStatus {
    ACTIVE, PAID, LOST
}

 class Address1 {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}

 class Person1 {
    private String name;
    private Address address;
    private String email;
    private String phone;
}

 class Location {
}

// For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter methods and modified only through their public methods function.

 abstract class Account1 {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword() {
        return false;
    }
}

 class Admin extends Account1 {
    /*

    public boolean addParkingFloor(ParkingFloor floor);
    public bool addParkingSpot(String floorName, ParkingSpot spot);
    public bool addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayBoard);
    public bool addCustomerInfoPanel(String floorName, CustomerInfoPanel infoPanel);

    public bool addEntrancePanel(EntrancePanel entrancePanel);
    public bool addExitPanel(ExitPanel exitPanel);

    */
 }

 class ParkingAttendant extends Account1 {
//    public bool processTicket(string TicketNumber);
}


 abstract class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType type;

    public boolean IsFree() {
        return false;
    }

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return free = false;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        return  free = true;
    }
 }

 class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot() {
        super(ParkingSpotType.HANDICAPPED);
    }
 }

 class CompactSpot extends ParkingSpot {
    public CompactSpot() {
        super(ParkingSpotType.COMPACT);
    }
 }

 class LargeSpot extends ParkingSpot {
    public LargeSpot() {
        super(ParkingSpotType.LARGE);
    }
 }

 class MotorbikeSpot extends ParkingSpot {
    public MotorbikeSpot() {
        super(ParkingSpotType.MOTORBIKE);
    }
 }

 class ElectricSpot extends ParkingSpot {
    public ElectricSpot() {
        super(ParkingSpotType.ELECTRIC);
    }
 }


 class ParkingTicket{

     public String getTicketNumber() {
         return "";
     }
 }


 abstract class Vehicle1 {
    private String licenseNumber;
    private final VehicleType1 type;
    private ParkingTicket ticket;

    public VehicleType1 getType(){
        return type;
    }

    public Vehicle1(VehicleType1 type) {
        this.type = type;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}

 class Car extends Vehicle1 {
    public Car() {
        super(VehicleType1.CAR);
    }
}

 class Van extends Vehicle1 {
    public Van() {
        super(VehicleType1.VAN);
    }
}

 class Truck extends Vehicle1 {
    public Truck() {
        super(VehicleType1.TRUCK);
    }
}

// Similarly we can define classes for Motorcycle and Electric vehicles


 class ParkingLot<EntrancePanel, ExitPanel, ParkingFloor, ParkingRate> {
    private String name;
    private Location address;
    private ParkingRate parkingRate;

    private int compactSpotCount;
    private int largeSpotCount;
    private int motorbikeSpotCount;
    private int electricSpotCount;
    private final int maxCompactCount=0;
    private final int maxLargeCount=0;
    private final int maxMotorbikeCount=0;
    private final int maxElectricCount=0;

    private HashMap<String, EntrancePanel> entrancePanels;
    private HashMap<String, ExitPanel> exitPanels;
    private HashMap<String, ParkingFloor> parkingFloors;

    // all active parking tickets, identified by their ticketNumber
    private HashMap<String, ParkingTicket> activeTickets;

    // singleton ParkingLot to ensure only one object of ParkingLot in the system,
    // all entrance panels will use this object to create new parking ticket: getNewParkingTicket(),
    // similarly exit panels will also use this object to close parking tickets
    private static ParkingLot parkingLot = null;

    // private constructor to restrict for singleton
    private ParkingLot() {
        // 1. initialize variables: read name, address and parkingRate from database
        // 2. initialize parking floors: read the parking floor map from database,
        //  this map should tell how many parking spots are there on each floor. This
        //  should also initialize max spot counts too.
        // 3. initialize parking spot counts by reading all active tickets from database
        // 4. initialize entrance and exit panels: read from database
    }

    // static method to get the singleton instance of ParkingLot
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    // note that the following method is 'synchronized' to allow multiple entrances
    // panels to issue a new parking ticket without interfering with each other
    public synchronized ParkingTicket getNewParkingTicket(Vehicle1 vehicle) {
        if (this.isFull(vehicle.getType())) {
           // throw new ParkingFullException();
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignTicket(ticket);
       // ticket.saveInDB();
        // if the ticket is successfully saved in the database, we can increment the parking spot count
        this.incrementSpotCount(vehicle.getType());
        this.activeTickets.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }

    public boolean isFull(VehicleType1 type) {
        // trucks and vans can only be parked in LargeSpot
        if (type == VehicleType1.TRUCK || type == VehicleType1.TRUCK) {
            return largeSpotCount >= maxLargeCount;
        }

        // motorbikes can only be parked at motorbike spots
        if (type == VehicleType1.MOTORBIKE) {
            return motorbikeSpotCount >= maxMotorbikeCount;
        }

        // cars can be parked at compact or large spots
        if (type == VehicleType1.CAR) {
            return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }

        // electric car can be parked at compact, large or electric spots
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
                + maxElectricCount);
    }

    // increment the parking spot count based on the vehicle type
    private void incrementSpotCount(VehicleType1 type) {
        if (type == VehicleType1.TRUCK || type == VehicleType1.VAN) {
            largeSpotCount++;
        } else if (type == VehicleType1.MOTORBIKE) {
            motorbikeSpotCount++;
        } else if (type == VehicleType1.CAR) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        } else { // electric car
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
    }

    public boolean isFull() {
        for (String key : parkingFloors.keySet()) {
 /*           if (!parkingFloors.get(key).isFull()) {
                return false;
            } */
        }
        return true;
    }

    public void addParkingFloor(ParkingFloor floor) {
        /* store in database */ }

    public void addEntrancePanel(EntrancePanel entrancePanel) {
        /* store in database */ }

    public void addExitPanel(ExitPanel exitPanel) {
        /* store in database */ }
}