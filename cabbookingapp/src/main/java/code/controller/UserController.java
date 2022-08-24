package code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import code.exception.DriverNotFoundException;
import code.model.Coordinate;
import code.model.Driver;
import code.model.User;
import code.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users/{userName}")
	public User getUser(@PathVariable String userName) {
		return userService.getUser(userName);
	}
	
	@RequestMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/users/{userName}/contactDetails")
	public void updateUserContactDetails(@RequestBody User user , @PathVariable String userName ) {
		userService.updateUser(userName, user.getContactDetails());
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/users/{userName}/location")
	public void updateUserLocation(@RequestBody User user, @PathVariable String userName) {
		userService.updateUserLocation(userName, user.getLocation());
	}
	
	@RequestMapping(value="/findRides" , method=RequestMethod.GET)
	public @ResponseBody List<Driver> getRides(@RequestParam("userName") String userName , 
								 @RequestParam("source") String source , 
								 @RequestParam("destination") String destination){
		
		String[] s1 = source.split(",");
		String[] s2 = destination.split(",");
		
		Coordinate src = new Coordinate(Integer.valueOf(s1[0]) , Integer.valueOf(s1[1]));
		Coordinate dst = new Coordinate(Integer.valueOf(s2[0]) , Integer.valueOf(s2[1]));
		System.out.println("Source: " + src.getX() + "," + src.getY());
		System.out.println("Destination: " + dst.getX() + "," + dst.getY());
		List<Driver> rides = userService.findRide(userName, src, dst);
		
		if(rides.isEmpty()) throw new DriverNotFoundException();
		return rides;
	}
	
	@RequestMapping(value="/choose" , method=RequestMethod.GET)
	public String chooseRide(@RequestParam("userName") String userName , 
								 @RequestParam("driverName") String driverName ){
		userService.chooseRide(userName, driverName);
		return "Ride Started";
	}
	
	@RequestMapping(value="/calculateBill" , method=RequestMethod.GET)
	public String calculateFare(@RequestParam("userName") String userName){
		return "Ride Ended Bill Amount:" + userService.calculateBill(userName);
	}	
	
}
