import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display main menu
            System.out.println("Welcome to the Vehicle Rental System");
            System.out.println("1. Rent a vehicle");
            System.out.println("2. Return a vehicle");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            if (action == 3) {
                System.out.println("Exiting the application.");
                break;
            }

            // Input vehicle type
            System.out.println("Select vehicle type:");
            System.out.println("1. Car");
            System.out.println("2. Motorcycle");
            System.out.println("3. Truck");
            System.out.print("Please enter your choice: ");
            int vehicleChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String vehicleType = "";
            switch (vehicleChoice) {
                case 1:
                    vehicleType = "car";
                    break;
                case 2:
                    vehicleType = "motorcycle";
                    break;
                case 3:
                    vehicleType = "truck";
                    break;
                default:
                    System.out.println("Invalid vehicle type.");
                    continue;
            }

            // Input license plate
            System.out.print("Enter license plate: ");
            String licensePlate = scanner.nextLine();

            Vehicle vehicle = null;
            switch (vehicleType) {
                case "car":
                    vehicle = new Car(licensePlate);
                    break;
                case "motorcycle":
                    vehicle = new Motorcycle(licensePlate);
                    break;
                case "truck":
                    vehicle = new Truck(licensePlate);
                    break;
                default:
                    System.out.println("Invalid vehicle type.");
                    continue;
            }

            if (action == 1) {
                // Input customer name
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                Customer customer = new Customer(name);

                // Input rental days
                System.out.print("Enter number of rental days: ");
                int days = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                ((Rentable) vehicle).rent(customer, days);
                System.out.println("Rental cost: " + vehicle.calculateRentalCost(days));
            } else if (action == 2) {
                ((Rentable) vehicle).returnVehicle();
            } else {
                System.out.println("Invalid action.");
            }

            // Ask if the user wants to continue or exit
            System.out.print("Do you want to continue or exit? (continue/exit): ");
            String continueOrExit = scanner.nextLine().toLowerCase();
            if (continueOrExit.equals("exit")) {
                System.out.println("Exiting the application.");
                break;
            }
        }

        scanner.close();
    }
}