public class Car extends Vehicle implements Rentable {
    private static final double BASE_RATE = 50.0;

    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return BASE_RATE * days;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            System.out.println("Car rented by " + customer.getName() + " for " + days + " days.");
        } else {
            System.out.println("Car is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car returned.");
    }
}