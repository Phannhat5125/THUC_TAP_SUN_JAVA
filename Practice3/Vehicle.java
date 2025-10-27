public class Vehicle {
    private String vehicleNumber;
    private String manufacturer;
    private int yearOfManufacture;
    private String color;
    private Owner owner;

    // Constructor
    public Vehicle(String vehicleNumber, String manufacturer, int yearOfManufacture, String color, Owner owner) {
        this.vehicleNumber = vehicleNumber;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.owner = owner;
    }

    // Getters and Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", color='" + color + '\'' +
                ", owner=" + owner +
                '}';
    }
}