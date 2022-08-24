package code.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.model.ContactDetails;
import code.model.Coordinate;
import code.model.Driver;
import code.model.User;

@Service
public class UserService {
	
	@Autowired
	DriverService driverService;
	
	@Autowired
	CalculateBill billService;
	
	@Autowired
	FindRide findRide;

	
	private HashMap<String , User> users;
	
	
	public UserService() {
		super();
		this.users = new HashMap<>();
	}

	public User getUser(String name){
		return  users.get(name);
	}
	
	public List<User> getUsers(){
		List<User> list = new ArrayList<User>(users.values());
		return list;
	}
	
	public void addUser(User user) {
		users.put(user.getName() , user);
	}
	
	public void updateUser(String name , ContactDetails contactDetails) {
		User user = users.get(name);
		user.setContactDetails(contactDetails);
	}
	
	public void updateUserLocation(String name , Coordinate location) {
		User user = users.get(name);
		user.setLocation(location);
	}
	
	public List<Driver> findRide(String name , Coordinate source , Coordinate destination) {
		User user = users.get(name);
		user.setSource(source);
		user.setDestination(destination);
		return findRide.findRides(source , driverService.getDrivers());
	}
	
	public void chooseRide(String userName , String driverName) {
		System.out.println("Ride Started");
		User user = users.get(userName);
		user.setDriverName(driverName);
		driverService.changeDriverStatus(driverName, false);
	}
	
	public double calculateBill(String userName) {
		return billService.calculatebill(userName , users.get(userName));
	}
}
