import java.util.List;

public abstract class Vehicle implements Actor {
	private LuxCompany company;
	private Location location;

	private Location targetLocation;
	private int idleCount;

	public Vehicle(LuxCompany company, Location location) {
		this.company = company;
		this.location = location;
	}

	public LuxCompany getCompany() {
		return this.company;
	}

	public Location getLocation() {
		return location;
	}

	public void setPickupLocation(Location location) {
		this.location = location;
	}

	public abstract void pickup(Passenger passenger);

	public abstract boolean isFree();

	public void notifyPickupArrival() {
		company.arrivedAtPickup(this);
	}

	public void notifyPassengerArrival(Passenger passengers) {

		company.arrivedAtDestination(this, passengers);
	}

	public void notifyPassengerArrivalBus(List<Passenger> passengers) {

		company.arrivedAtDestinationBus(this, passengers);
	}

	public void setLocation(Location location) {
		if (location != null) {
			this.location = location;
		} else {
			throw new NullPointerException();
		}

	}

	public void clearTargetLocation() {
		targetLocation = null;
	}

	public int getIdleCount() {
		return idleCount;
	}

	public void incrementIdleCount() {
		idleCount++;
	}

	public Location getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(Location location) {
		if (location != null) {
			targetLocation = location;
		} else {
			throw new NullPointerException();
		}
	}

}
