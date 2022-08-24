package code.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import code.model.Coordinate;
import code.model.Driver;

@Service
public class DriverService {
	
	private HashMap<String , Driver> drivers;
	
	
	public DriverService() {
		this.drivers = new HashMap<>();
	}

	public Driver getDriver(String name) {
		return drivers.get(name);
	}
	
	public List<Driver> getDrivers(){
		List<Driver> list = new ArrayList<Driver>(drivers.values());
		return list;
	}
	
	public void addDriver(Driver driver) {
		drivers.put(driver.getName() , driver);
	}
	
	public void updateDriverLocation(String name , Coordinate location) {
		Driver driver = drivers.get(name);
		driver.setLocation(location);
	}
	
	public void changeDriverStatus(String name , boolean status) {
		Driver driver = drivers.get(name);
		driver.setAvailable(status);
	}

	public String getTotalEarnings() {
		String total = "";
		for(Driver driver : drivers.values()) {
			total += driver.getName() + " earned " + driver.getEarnings() + "\n";
		}
		return total;
	}
	
}
