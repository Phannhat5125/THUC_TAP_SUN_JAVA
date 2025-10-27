public class Truck extends Vehicle {
    private double tonnage;

    // Constructor
    public Truck(String vehicleNumber, String manufacturer, int yearOfManufacture, String color, Owner owner, double tonnage) {
        super(vehicleNumber, manufacturer, yearOfManufacture, color, owner);
        this.tonnage = tonnage;
    }

    // Getters and Setters
    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return "Truck{" +
                super.toString() +
                ", tonnage=" + tonnage +
                '}';
    }
}