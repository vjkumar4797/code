package code.model;

import org.springframework.stereotype.Component;

@Component
public class Driver extends Person{
	
	private Vehicle vehicle;
	private Coordinate location;
	private boolean isAvailable;
	private double earnings;
	
	public Driver() {
		super("", Gender.M, 100);
	}
	
	

	public Driver(String name, Gender gender, int age, ContactDetails contactDetails, Vehicle vehicle,
			Coordinate location, boolean isAvailable, double earnings) {
		super(name, gender, age, contactDetails);
		this.vehicle = vehicle;
		this.location = location;
		this.isAvailable = isAvailable;
		this.earnings = earnings;
	}



	public Driver(String name, Gender gender, int age, Vehicle vehicle, boolean isAvailable) {
		super(name, gender, age);
		this.vehicle = vehicle;
		this.setLocation(new Coordinate(0,0));
		this.isAvailable = isAvailable;
		this.earnings = 0.0;
	}

	public Driver(String name, Gender gender, int age, Vehicle vehicle , boolean isAvailable , Coordinate location) {
		super(name, gender, age);
		this.vehicle = vehicle;
		this.location = location;
		this.isAvailable = isAvailable;
		this.earnings = 0.0;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getEarnings() {
		return earnings;
	}

	public void addEarnings(double earnings) {
		this.earnings += earnings;
	}
	
	
}
