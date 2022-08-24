package code.model;

public abstract class Vehicle {
	
	private String model;
	private String no;
	
	public Vehicle(String model, String no) {
		this.model = model;
		this.no = no;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	
	
}
