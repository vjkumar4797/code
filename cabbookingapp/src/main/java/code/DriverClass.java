package code;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import code.model.Car;
import code.model.ContactDetails;
import code.model.Coordinate;
import code.model.Driver;
import code.model.Gender;
import code.model.User;
import code.service.DriverService;
import code.service.UserService;


@SpringBootApplication
public class DriverClass {
	

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(DriverClass.class, args);

		UserService userService = appContext.getBean(UserService.class);
		userService.addUser(new User("Abhishek", Gender.M , 23 ,new ContactDetails(901030405)));
		userService.addUser(new User("Rahul", Gender.M , 29));
		userService.addUser(new User("Nandini", Gender.F , 22));
		
		DriverService driverService = appContext.getBean(DriverService.class);
		driverService.addDriver(new Driver("Driver1" , Gender.M , 22 , 
								new Car("Swift" , "KA-01-12345") , true , new Coordinate(10,1)));
		driverService.addDriver(new Driver("Driver2" , Gender.M , 29 , 
				new Car("Swift" , "KA-01-12345") , true, new Coordinate(11,10)));
		driverService.addDriver(new Driver("Driver3" , Gender.M , 24 , 
				new Car("Swift" , "KA-01-12345") , true, new Coordinate(5,3)));
	}

}
