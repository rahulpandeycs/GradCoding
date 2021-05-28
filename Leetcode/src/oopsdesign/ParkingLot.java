package src.oopsdesign;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.*;

import static java.util.Arrays.asList;

enum ParkingStatus {
    EMPTY,
    OCCUPIED;
}

class ParkingSlot {

    private String slotId;
    private String slotNumber;
    private ParkingStatus status;
    private SlotSize slotSize;
    private Vehicle vehicle;

    public ParkingSlot(String slotId, String slotNumber, ParkingStatus status, SlotSize slotSize) {
        this.slotId = slotId;
        this.slotNumber = slotNumber;
        this.status = status;
        this.slotSize = slotSize;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (this.slotSize.isVehicleParkingPossible(vehicle)) {
            this.vehicle = vehicle;
            status = ParkingStatus.OCCUPIED;
        } else {
            throw new IllegalArgumentException("parking not possible for this vehicle type in this slot");
        }
    }

    public void emptySlot() {
        this.vehicle = null;
        status = ParkingStatus.EMPTY;
    }

}


class Floor {

    private String floorId;
    private int floorNumber;
    private String floorName;
    private List<ParkingSlot> parkingSlots;

    public Floor(String floorId, int floorNumber, String floorName, List<ParkingSlot> parkingSlots) {
        this.floorId = floorId;
        this.floorNumber = floorNumber;
        this.floorName = floorName;
        this.parkingSlots = parkingSlots;
    }


    public void emptyFloor() {
        for (ParkingSlot slot: parkingSlots) {
            slot.emptySlot();
        }
    }

}

class Parking {
    private String parkingId;
    private List<Floor> floors;
    private String parkingName;
    private String address;

    public Parking(String parkingId, List<Floor> floors, String parkingName, String address) {
        this.parkingId = parkingId;
        this.floors = floors;
        this.parkingName = parkingName;
        this.address = address;
    }

    public void emptyWholeParkingLot() {
        for (Floor floor : floors) {
            floor.emptyFloor();
        }
    }
}

enum VehicleType {
    BIKE,
    COMPACT,
    SEDAN,
    TRUCK
}

interface Vehicle {
    public VehicleType getType();
}

class Bike implements Vehicle {

    private String bikeNumber;

    public Bike(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    @Override
    public String toString() {
        return "bike number=" + bikeNumber;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }

}

class HatchBackCar implements Vehicle {

    private String carNumber;

    public HatchBackCar(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "car number=" + carNumber;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.COMPACT;
    }
}

class Sedan implements Vehicle {

    private String carNumber;

    public Sedan(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "car number=" + carNumber;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.SEDAN;
    }

}

enum SlotSize {

    SMALL(asList(VehicleType.BIKE, VehicleType.COMPACT)),
    MEDIUM(asList(VehicleType.BIKE, VehicleType.COMPACT, VehicleType.SEDAN)),
    LARGE(asList(VehicleType.BIKE, VehicleType.COMPACT, VehicleType.SEDAN, VehicleType.TRUCK));

    private final List<VehicleType> vehicleTypesAllowed;

    SlotSize(List<VehicleType> vehicleTypes) {
        this.vehicleTypesAllowed = vehicleTypes;
    }

    public boolean isVehicleParkingPossible(Vehicle vehicle) {
        return vehicleTypesAllowed.contains(vehicle.getType());
    }
}

class FareController {

    private Map<Vehicle, ParkingDetails> vehicleParkingDetailsMap = new HashMap<>();

    public void onVehicleEntry(Vehicle vehicle, Parking parking) {
        vehicleParkingDetailsMap.put(vehicle, new ParkingDetails(vehicle, parking, new Date(), null));
    }

    public void onVehicleExit(Vehicle vehicle) {
        ParkingDetails parkingDetails = vehicleParkingDetailsMap.get(vehicle);
        parkingDetails.exitTime = new Date();
    }

    public BigDecimal getFare(Vehicle vehicle) {
        ParkingDetails parkingDetails = vehicleParkingDetailsMap.get(vehicle);
        return getFare(parkingDetails.parking, parkingDetails.entryTime, parkingDetails.exitTime);
    }

    private BigDecimal getFare(Parking parking, Date entryTime, Date exitTime) {
        return null;
    }

}

class ParkingDetails {
    Vehicle vehicle;
    Parking parking;
    Date entryTime;
    Date exitTime;

    public ParkingDetails(Vehicle vehicle, Parking parking, Date entryTime, Date exitTime) {
        this.vehicle = vehicle;
        this.parking = parking;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }
}
