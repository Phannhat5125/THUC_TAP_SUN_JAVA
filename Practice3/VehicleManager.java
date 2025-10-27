import java.util.*;

public class VehicleManager {
    private List<Vehicle> vehicles;

    public VehicleManager() {
        this.vehicles = new ArrayList<>();
    }

    // Add a vehicle
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Search vehicle by vehicle number
    public Vehicle searchByVehicleNumber(String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return vehicle;
            }
        }
        return null;
    }

    // Find vehicles by owner ID
    public List<Vehicle> findByOwnerId(String ownerId) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOwner().getIdNumber().equals(ownerId)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    // Delete vehicles by manufacturer
    public void deleteByManufacturer(String manufacturer) {
        vehicles.removeIf(vehicle -> vehicle.getManufacturer().equals(manufacturer));
    }

    // Find manufacturer with most vehicles
    public String findManufacturerWithMostVehicles() {
        Map<String, Integer> manufacturerCount = new HashMap<>();
        for (Vehicle vehicle : vehicles) {
            manufacturerCount.put(vehicle.getManufacturer(), manufacturerCount.getOrDefault(vehicle.getManufacturer(), 0) + 1);
        }
        return Collections.max(manufacturerCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // Sort vehicles by descending order of number of vehicles
    public void sortVehiclesByDescending() {
        vehicles.sort((v1, v2) -> v2.getVehicleNumber().compareTo(v1.getVehicleNumber()));
    }

    // Statistics of vehicle types
    public Map<String, Integer> getVehicleStatistics() {
        Map<String, Integer> stats = new HashMap<>();
        int cars = 0, motorcycles = 0, trucks = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                cars++;
            } else if (vehicle instanceof Motorcycle) {
                motorcycles++;
            } else if (vehicle instanceof Truck) {
                trucks++;
            }
        }
        stats.put("Cars", cars);
        stats.put("Motorcycles", motorcycles);
        stats.put("Trucks", trucks);
        return stats;
    }

    // Display all vehicles
    public void displayVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}