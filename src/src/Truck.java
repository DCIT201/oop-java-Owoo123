public class Truck extends Vehicle implements Rentable{
	private static final double BASE_RATE = 80.0;

	public Truck(String lincensePlate) {
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
		if(isAvailableForRental()) {
			setAvailable(isAvailable());
			System.out.println("Truck rented by " + customer.getName() + " for " + days + " days.");
		} else {
			System.out.println("Truck is not available for rental.");
		}
	}

	@Override
	public void returnVehicle() {
		setAvailable(true);
		System.out.println("Truck returned.");
	}
}
