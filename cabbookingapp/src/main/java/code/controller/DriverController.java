package code.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import code.model.Driver;
import code.service.DriverService;

@RestController
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@RequestMapping("/drivers/{driverName}")
	public Driver getDriver(@PathVariable String driverName) {
		return driverService.getDriver(driverName);
	}
	
	@RequestMapping("/drivers")
	public List<Driver> getDrivers() {
		return driverService.getDrivers();
	}	
	
	@RequestMapping(method=RequestMethod.POST, value="/drivers")
	public void addDriver(@RequestBody Driver driver) {
		driverService.addDriver(driver);
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/drivers/{driverName}/status")
	public void updateDriverContactDetails(@RequestBody Driver driver , @PathVariable String userName ) {
		driverService.changeDriverStatus(userName, driver.isAvailable());
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/drivers/{driverName}/location")
	public void updateDriverLocation(@RequestBody Driver driver , @PathVariable String userName) {
		driverService.updateDriverLocation(userName, driver.getLocation());
	}
	
	@RequestMapping(value="/totalEarnings" , method=RequestMethod.GET)
	public String calculateFare(){
		return driverService.getTotalEarnings();
	}	
	
}
