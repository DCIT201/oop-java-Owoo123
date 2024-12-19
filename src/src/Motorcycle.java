public class Motorcycle extends Vehicle implements Rentable {
	private static final double BASE_RATE = 10.0;

	public Motorcycle(String lincensePlate) {
		super(lincensePlate);
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
			setAvailable(isAvailable());
			System.out.println("Motorcycle rented by " + customer.getName() + " for " + days + " days.");
		} else {
			System.out.println("Motorcycle is not available for rental.");
		}
	}

	@Override
	public void returnVehicle() {
		setAvailable(true);
		System.out.println("Motorcycle returned.");
	}
}
