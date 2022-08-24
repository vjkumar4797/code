package code.model;

public class Car extends Vehicle{
	
	private final VehicleType type = VehicleType.Car;
	
	public Car(String model, String no) {
		super(model, no);
	}
	
	public VehicleType getType() {
		return type;
	}
}
