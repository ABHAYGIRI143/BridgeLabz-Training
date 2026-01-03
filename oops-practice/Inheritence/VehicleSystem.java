// Superclass Vehicle
class Vehicles {
    String model;
    int maxSpeed;

    Vehicles(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void showDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface Refuelable
interface Refuelable {
    void refuel();
}

// Subclass ElectricVehicle (inherits Vehicle)
class ElectricVehicle extends Vehicles {

    ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    void charge() {
        System.out.println(model + " is charging at the station.");
    }
}

// Subclass PetrolVehicle (inherits Vehicle + implements Refuelable)
class PetrolVehicle extends Vehicles implements Refuelable {

    PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void refuel() {
        System.out.println(model + " is being refueled with petrol.");
    }
}

// Main class
public class VehicleSystem {
    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 220);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180);

        ev.showDetails();
        ev.charge();

        System.out.println();

        pv.showDetails();
        pv.refuel();
    }
}
