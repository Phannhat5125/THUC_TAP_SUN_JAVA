public class Motorcycle extends Vehicle {
    private int capacity;

    // Constructor
    public Motorcycle(String vehicleNumber, String manufacturer, int yearOfManufacture, String color, Owner owner, int capacity) {
        super(vehicleNumber, manufacturer, yearOfManufacture, color, owner);
        this.capacity = capacity;
    }

    // Getters and Setters
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                super.toString() +
                ", capacity=" + capacity +
                '}';
    }
}