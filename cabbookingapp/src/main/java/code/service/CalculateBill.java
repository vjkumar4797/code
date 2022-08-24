package code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.model.Driver;
import code.model.User;

@Service
public class CalculateBill {
	
	private double standardRate = 1.0;
	

	@Autowired
	DriverService driverService;
	
	@Autowired
	FindRide findDist;
	
	public double calculatebill(String userName , User user) {
		Driver driver = driverService.getDriver(user.getDriverName()); 
		double fare = findDist.findDistance(user.getSource(), user.getDestination()) * standardRate;
		System.out.println(fare);
		driver.addEarnings(fare);
		user.setLocation(user.getDestination());
		driver.setLocation(user.getDestination());
		driver.setAvailable(true);
		return fare;
	}
	
	
}
