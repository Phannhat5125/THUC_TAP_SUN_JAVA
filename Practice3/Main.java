import java.util.*;

public class Main {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        Owner o1 = new Owner("012345678901", "Nguyen Van A", "a@example.com");
        Owner o2 = new Owner("111111111111", "Tran Thi B", "b@example.com");
        manager.addVehicle(new Car("A1234", "Toyota", 2010, "Red", o1, 4, "V8"));
        manager.addVehicle(new Motorcycle("B5678", "Honda", 2018, "Black", o2, 150));
        manager.addVehicle(new Truck("C0001", "Suzuki", 2020, "White", o1, 2.5));
        do {
            System.out.println("\n--- Vehicle Management System ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Search Vehicle by Number");
            System.out.println("3. Find Vehicles by Owner ID");
            System.out.println("4. Delete Vehicles by Manufacturer");
            System.out.println("5. Manufacturer with Most Vehicles");
            System.out.println("6. Sort Vehicles by Descending Order");
            System.out.println("7. Vehicle Type Statistics");
            System.out.println("8. Display All Vehicles");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle type (Car/Motorcycle/Truck): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter vehicle number: ");
                    String vehicleNumber = scanner.nextLine();
                    System.out.print("Enter manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Enter year of manufacture: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter owner ID: ");
                    String ownerId = scanner.nextLine();
                    while (!ownerId.matches("\\d{12}")) {
                        System.out.println("Invalid ID! ID must be exactly 12 digits.");
                        System.out.print("Enter owner ID: ");
                        ownerId = scanner.nextLine();
                    }

                    System.out.print("Enter owner email: ");
                    String ownerEmail = scanner.nextLine();
                    while (!ownerEmail.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                        System.out.println("Invalid email format! Please enter a valid email.");
                        System.out.print("Enter owner email: ");
                        ownerEmail = scanner.nextLine();
                    }
                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();

                    Owner owner = new Owner(ownerId, ownerName, ownerEmail);

                    if (type.equalsIgnoreCase("Car")) {
                        System.out.print("Enter number of seats: ");
                        int seats = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter engine type: ");
                        String engineType = scanner.nextLine();
                        manager.addVehicle(new Car(vehicleNumber, manufacturer, year, color, owner, seats, engineType));
                    } else if (type.equalsIgnoreCase("Motorcycle")) {
                        System.out.print("Enter capacity: ");
                        int capacity = scanner.nextInt();
                        scanner.nextLine();
                        manager.addVehicle(new Motorcycle(vehicleNumber, manufacturer, year, color, owner, capacity));
                    } else if (type.equalsIgnoreCase("Truck")) {
                        System.out.print("Enter tonnage: ");
                        double tonnage = scanner.nextDouble();
                        scanner.nextLine();
                        manager.addVehicle(new Truck(vehicleNumber, manufacturer, year, color, owner, tonnage));
                    } else {
                        System.out.println("Invalid vehicle type!");
                    }
                    break;
                case 2:
                    System.out.print("Enter vehicle number to search: ");
                    String searchNumber = scanner.nextLine();
                    Vehicle foundVehicle = manager.searchByVehicleNumber(searchNumber);
                    if (foundVehicle != null) {
                        System.out.println(foundVehicle);
                    } else {
                        System.out.println("Vehicle not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter owner ID to find vehicles: ");
                    String searchOwnerId = scanner.nextLine();
                    List<Vehicle> ownerVehicles = manager.findByOwnerId(searchOwnerId);
                    if (!ownerVehicles.isEmpty()) {
                        for (Vehicle v : ownerVehicles) {
                            System.out.println(v);
                        }
                    } else {
                        System.out.println("No vehicles found for this owner!");
                    }
                    break;
                case 4:
                    System.out.print("Enter manufacturer to delete vehicles: ");
                    String manufacturerToDelete = scanner.nextLine();
                    manager.deleteByManufacturer(manufacturerToDelete);
                    System.out.println("Vehicles deleted successfully.");
                    break;
                case 5:
                    String topManufacturer = manager.findManufacturerWithMostVehicles();
                    System.out.println("Manufacturer with most vehicles: " + topManufacturer);
                    break;
                case 6:
                    manager.sortVehiclesByDescending();
                    System.out.println("Vehicles sorted successfully.");
                    break;
                case 7:
                    Map<String, Integer> stats = manager.getVehicleStatistics();
                    System.out.println("Vehicle Statistics:");
                    stats.forEach((typeKey, count) -> System.out.println(typeKey + ": " + count));
                    break;
                case 8:
                    manager.displayVehicles();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}