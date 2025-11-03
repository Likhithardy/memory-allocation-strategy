// Base class
class Vehicle {
    String brand;
    String model;
    double rentalPricePerDay;

    // Constructor
    Vehicle(String brand, String model, double rentalPricePerDay) {
        this.brand = brand;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    // Method to calculate rental
    double calculateRental(int days) {
        return rentalPricePerDay * days;
    }
}

// Subclass Car
class Car extends Vehicle {
    int noOfDoors;

    Car(String brand, String model, double rentalPricePerDay, int noOfDoors) {
        super(brand, model, rentalPricePerDay);
        this.noOfDoors = noOfDoors;
    }

    @Override
    double calculateRental(int days) {
        return super.calculateRental(days); // Same as base
    }
}

// Subclass Bike
class Bike extends Vehicle {
    boolean helmetIncluded;

    Bike(String brand, String model, double rentalPricePerDay, boolean helmetIncluded) {
        super(brand, model, rentalPricePerDay);
        this.helmetIncluded = helmetIncluded;
    }

    @Override
    double calculateRental(int days) {
        // 10% discount if helmet included
        double cost = super.calculateRental(days);
        if (helmetIncluded) {
            cost *= 0.9; 
        }
        return cost;
    }
}

// Subclass Truck
class Truck extends Vehicle {
    double loadCapacity; // in tons

    Truck(String brand, String model, double rentalPricePerDay, double loadCapacity) {
        super(brand, model, rentalPricePerDay);
        this.loadCapacity = loadCapacity;
    }

    @Override
    double calculateRental(int days) {
        // Extra 500 per day if load capacity > 5 tons
        double cost = super.calculateRental(days);
        if (loadCapacity > 5) {
            cost += 500 * days;
        }
        return cost;
    }
}

// Main class
public class VehicleRentalApp {
    public static void main(String[] args) {
        // Create objects
        Car car = new Car("Toyota", "Camry", 2000, 4);
        Bike bike = new Bike("Honda", "CBR", 800, true);
        Truck truck = new Truck("Volvo", "FH16", 5000, 8);

        int days = 3; // Example rental duration

        System.out.println("Car Rental for " + days + " days: " + car.calculateRental(days));
        System.out.println("Bike Rental for " + days + " days: " + bike.calculateRental(days));
        System.out.println("Truck Rental for " + days + " days: " + truck.calculateRental(days));
    }
}
