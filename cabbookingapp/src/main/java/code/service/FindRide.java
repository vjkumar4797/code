package code.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import code.model.Coordinate;
import code.model.Driver;

@Service
public class FindRide {
	
	
	public List<Driver> findRides(Coordinate location , List<Driver> drivers){
		
		List<Driver> availableDrivers = new ArrayList<Driver>();
		
		for(Driver driver : drivers) {
			int distance = findDistance(location , driver.getLocation());
			if(distance <= 5 && driver.isAvailable()) {
				availableDrivers.add(driver);
			}
		}
		
		return availableDrivers;
	}

	protected int findDistance(Coordinate l1, Coordinate l2) {
		int x1 = l1.getX(),
			x2 = l2.getX(),
			y1 = l1.getY(),
			y2 = l2.getY();
		
		double dist = Math.ceil(
						Math.sqrt(
								Math.pow(Math.abs(x1-x2) , 2) + Math.pow(Math.abs(y1-y2) , 2) 
									)
										);
		
		System.out.println("FindDistance Method\nDistance: " + dist);
		
		return (int) dist;
	}
}
