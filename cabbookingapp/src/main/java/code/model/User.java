package code.model;

import org.springframework.stereotype.Component;

@Component
public class User extends Person{
	
	private Coordinate currentLocation;
	private Coordinate source;
	private Coordinate destination;
	private String driverName;
	
	public User() {
		super("name" , Gender.M , 100);
	}
	
	public User(String name, Gender gender, int age) {
		super(name , gender , age);
	}

	public User(String name, Gender gender, int age, ContactDetails contactDetails) {
		super(name, gender, age, contactDetails);
	}

	public User(String name, Gender gender, int age, ContactDetails contactDetails, Coordinate location) {
		super(name, gender, age, contactDetails);
		currentLocation = location;
	}

	public Coordinate getLocation() {
		return currentLocation;
	}

	public void setLocation(Coordinate location) {
		currentLocation = location;
	}

	public Coordinate getSource() {
		return source;
	}

	public void setSource(Coordinate source) {
		this.source = source;
	}

	public Coordinate getDestination() {
		return destination;
	}

	public void setDestination(Coordinate destination) {
		this.destination = destination;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
}
