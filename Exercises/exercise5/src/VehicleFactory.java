// Vehicle interface
interface Vehicle {
    void startEngine();
}

// Concrete implementations
class Car implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }
}

class Motorbike implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Motorbike engine started.");
    }
}

// Factory Class
class VehicleFactory {
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        if (vehicleType.equalsIgnoreCase("CAR")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("MOTORBIKE")) {
            return new Motorbike();
        }
        return null;
    }
}
